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
      fecha()
      asignarBotones(data)
      
  } catch (error) {
      console.log(error)
  }
  
}


// Analizar situación botones dia y hora////////////////////////////////////

const fecha = () =>{
  // crea un nuevo objeto `Date`, obtengo fecha y hora actual
var today = new Date();
let dia = today.getDay()
let hora = today.getHours()
let minutos = today.getMinutes()


console.log("el dia es ",dia)
console.log("La hora es" ,hora," con ",minutos," minutos")
let botones = document.querySelectorAll(".botComprar")
let aviso = document.getElementById("aviso")
if(dia > 0 && dia <6){
  //dia de semana de 20 a 00
  if( hora >= 20  ){
      if(hora <= 23 && minutos <= 59 ){
          console.log("estamos abiertos")
          aviso.style.display = "none";
      }
  } else{
      console.log("estamos cerrados")
      // botones.forEach(elemento => elemento.disabled = true);
      
  }
} else if ( dia == 7 || dia == 0){
  //fin de semana de 11 a 15
  if( hora >= 11  ){
      if(hora <= 14 && minutos <= 59 ){
          console.log("estamos abiertos")
          aviso.style.display = "none";
      }
  } else{
      console.log("estamos cerrados")
      // botones.forEach(elemento => elemento.disabled = true);
  }
}



}

///////////////////////////////////////////////////////////////////////////////////


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
/////////////////////////////////////////////////////////

//Botones menu platos
const menu = document.querySelector(".menuCambio");
let tipo = 3;
const botTodo = document.querySelector("#todo")
botTodo.addEventListener("click",()=>{
  limpiarHtml(contenedorPro);
  pintar(data1);
  menu.innerHTML = "Completo"
  asignarBotones(data1)
})

const botPri = document.querySelector("#principal")

botPri.addEventListener("click",()=>{
  limpiarHtml(contenedorPro);
  tipo = 1;
  pintarSele(data1);
  menu.innerHTML = "Principal"
  asignarBotones(data1)

})

const botGuar = document.querySelector("#guarnicion")
botGuar.addEventListener("click",()=>{
  limpiarHtml(contenedorPro);
  tipo = 2;
  pintarSele(data1)
  menu.innerHTML = "Guarniciones"
  asignarBotones(data1)
})
/////////////////////////////////////////////////////////////


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

/////////////////////////CARRITO DE COMPRAS//////////////////////////////////////////


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
                    }
                }
    }
    
    for(let k = 0; k < 6; k++) {
        let numeroFila = "fila-" + k
        let k1 = k + 1
        if (datosProductos[k].cantidad > 0) {
            document.getElementById(numeroFila).innerHTML = 
            '<img src="'+ datosProductos[k].thumbnailUrl + '" width="60" height="60">' +
            '<td>' + datosProductos[k].nombre + '</td>' +
            '<td>' + datosProductos[k].cantidad + '</td>' +
            '<td>' + '<button class="btn btn-info btn-sm" onclick="agregarElemento(' + k1 + ');"> + </button> <button class="btn btn-danger btn-sm" onclick="quitarElemento(' + k1 + ');"> - </button>' + '</td>' +
            '<td>' + datosProductos[k].precio * datosProductos[k].cantidad + '</td>';
        }
    }

    document.getElementById("fila-final").innerHTML =
    '<td>' + '<button class="btn btn-info btn-sm" onclick="#"> CONFIRMAR PEDIDO </button>' + '</td>' +
    '<td></td>' +
    '<td></td>' +
    '<td>' + '<button class="btn btn-danger btn-sm" onclick="vaciarCarrito()"> VACIAR </button>' + '</td>' +
    '<td> Subtotal: ' + totalPrecio + '</td>';

    let filasRevisadas = 0
    for(let l = 0; l < 6; l++) {
        let numeroFila = "fila-" + l
        if (datosProductos[l].cantidad == 0) {
            document.getElementById(numeroFila).innerHTML = '';
            filasRevisadas++
        }
        if (filasRevisadas >= 6) {
            document.getElementById("fila-final").innerHTML = '';
        }
    }
}
}


//
function quitarElemento(id) {
    let carritoLength = arrayCarrito.length
    let position = 0

    do {
        if(arrayCarrito[position] == id) {
            delete arrayCarrito[position]
            position = carritoLength

        }
        else {
            position++
        }
        
    }while(position != carritoLength)
    dibujarElementoCarrito(arrayCarrito)
}


//
function vaciarCarrito() {
    arrayCarrito = []

    for(i = 0; i < 6; i++) {
        let numeroFila = "fila-" + i
        document.getElementById(numeroFila).innerHTML = '';
    }
    document.getElementById("fila-final").innerHTML = '';
}


/////////////////////////FIN DEL CARRITO DE COMPRAS//////////////////////////////////////////