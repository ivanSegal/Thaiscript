//Espere que el DOM sea cargadoo
document.addEventListener('DOMContentLoaded',e =>{
    fetchData();
})
let data1
const fetchData = async () =>{
    try {
        const resp = await fetch("comidas.json");
        const data = await resp.json();
        
        pintar(data)
        data1=data
        pintarSele(data1)
        
    } catch (error) {
        console.log(error)
    }
    
}

//Pintar la pagina principal con todos los objetos json

const contenedorPro = document.querySelector("#contenedor-productos");

const pintar = data =>{
    const template = document.querySelector("#template-productos").content;
    const fragment = document.createDocumentFragment();
    //recorrer arreglo de objetos

    data.forEach(element => {
        template.querySelector("img").setAttribute("src",element.thumbnailUrl);
        template.querySelector("h5").textContent = element.nombre;
        template.querySelector("span").textContent = element.precio;
        template.querySelector("button").dataset.id = element.id;

        template.querySelector(".parra").textContent = element.decripcion;
        template.querySelector(".ingr").textContent = element.ingredientes;

        template.querySelector(".colbu").setAttribute("data-bs-target",element.target);
        template.querySelector(".collapse").setAttribute("id",element.idd)

        
        const clone = template.cloneNode(true)

        fragment.appendChild(clone)
    });
    contenedorPro.appendChild(fragment)
}


//Botones menu platos
const menu = document.querySelector(".menuCambio");
let tipo = 3;
const botTodo = document.querySelector("#todo")
botTodo.addEventListener("click",()=>{
    limpiarHtml(contenedorPro);
    pintar(data1);
    menu.innerHTML = "Completo"
})

const botPri = document.querySelector("#principal")

botPri.addEventListener("click",()=>{
    limpiarHtml(contenedorPro);
    tipo = 1;
    pintarSele(data1);
    menu.innerHTML = "Principal"

})

const botGuar = document.querySelector("#guarnicion")
botGuar.addEventListener("click",()=>{
    limpiarHtml(contenedorPro);
    tipo = 2;
    pintarSele(data1)
    menu.innerHTML = "Guarniciones"
})



//Pintar la pagina principal principal y guarnicion


const pintarSele = data1 =>{
    const template = document.querySelector("#template-productos").content;
    const fragment = document.createDocumentFragment();
    
    //recorrer arreglo de objetos
    if(tipo == 1){
        data1.forEach(element => {
            if(element.principal == true){
                template.querySelector("img").setAttribute("src",element.thumbnailUrl);
                template.querySelector("h5").textContent = element.nombre;
                template.querySelector("span").textContent = element.precio;
                template.querySelector("button").dataset.id = element.id;
        
                template.querySelector(".parra").textContent = element.decripcion;
                template.querySelector(".ingr").textContent = element.ingredientes;
        
                template.querySelector(".colbu").setAttribute("data-bs-target",element.target);
                template.querySelector(".collapse").setAttribute("id",element.idd)
        
                
                const clone = template.cloneNode(true)
        
                fragment.appendChild(clone)} 
        });
        contenedorPro.appendChild(fragment)
    } else if (tipo == 2){
        
        data1.forEach(element => {
            if(element.principal != true){
                template.querySelector("img").setAttribute("src",element.thumbnailUrl);
                template.querySelector("h5").textContent = element.nombre;
                template.querySelector("span").textContent = element.precio;
                template.querySelector("button").dataset.id = element.id;
        
                template.querySelector(".parra").textContent = element.decripcion;
                template.querySelector(".ingr").textContent = element.ingredientes;
        
                template.querySelector(".colbu").setAttribute("data-bs-target",element.target);
                template.querySelector(".collapse").setAttribute("id",element.idd)
        
                
                const clone = template.cloneNode(true)
        
                fragment.appendChild(clone)} 
        });

        contenedorPro.appendChild(fragment)
    }
    
    
    
}

//buscador

document.addEventListener('keyup', e =>{
    if(e.target.matches('#buscador')){
        document.querySelectorAll('.articulo').forEach(plato =>{
            plato.textContent.toLowerCase().includes(e.target.value)
            ? plato.classList.remove('filtro')
            : plato.classList.add('filtro');

        })
    }
})

//limpiar pantalla
const limpiarHtml = (contenedor) =>{
    while(contenedor.firstChild){
        contenedor.removeChild(contenedor.firstChild);
    }
}


//Mostrar carrito
const mostCarro = document.querySelector(".botCarrito")
const vistaCarro = document.querySelector(".carrito")
var mostrandoCarro = false
mostCarro.addEventListener("click",()=>{
    if (mostrandoCarro == false) {
        vistaCarro.style.display = "flex"
        mostrandoCarro = true
    }
    else {
        vistaCarro.style.display = "none"
        mostrandoCarro = false
    }
    
})


//Cerrar carrito
const butCerrar = document.querySelector(".butonCerrar")
butCerrar.addEventListener("click",()=>{
    vistaCarro.style.display = "none"
})


//Cuando el usuario clickea un botón, se guarda el id del elemento clickeado
let arrayCarrito = [];
function agregarElemento(id) {
    arrayCarrito.push(id)
    console.log(arrayCarrito)
    dibujarElementoCarrito(arrayCarrito)
}


//
function dibujarElementoCarrito(arrayCarrito) {
    let carritoLength = arrayCarrito.length

//
let datosProductos = {};
fetch("comidas.json")
    .then(function(resp) {
        return resp.json();
    })
    .then(function(data) {
        datosProductos = data;
        mostrarObj()
    });

//
let mostrarObj = function() {
    for (let prop in datosProductos) {
        for(let i = 0; i < 6; i++) {
            datosProductos[i].cantidad = 0
        }
        console.log(datosProductos)
        dibujo()
    }
}

//
function dibujo() {
    let totalPrecio = 0
    for(let i = 0; i < carritoLength; i++) { //for para recorrer arrayCarrito
        for(let j =  0; j < 6; j++) { //for para recorrer datosProductos
            if (arrayCarrito[i] == datosProductos[j].id) {
                datosProductos[j].cantidad++
                totalPrecio = totalPrecio + datosProductos[j].precio
                document.getElementById("footer").innerHTML = 
                '<table>' +
                    '<tr>' +
                        // '<img src="'+ datosProductos[i].thumbnailUrl + '>' +
                        '<td>' + datosProductos[j].nombre + '</td>' +
                        '<td>' + datosProductos[j].cantidad + '</td>' +
                        '<td>Placeholder</td>' +
                        '<td>'+ totalPrecio + '</td>' +
                    '</tr>' +
                    '<tr>' +
                        '<td> Hi </td>' +
                    '</tr>' +
                '</table>';
            }
        }
    }
}

}