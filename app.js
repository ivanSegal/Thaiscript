//Espere que el DOM sea cargadoo
document.addEventListener('DOMContentLoaded',e =>{
    fetchData();
})

const fetchData = async () =>{
    try {
        const resp = await fetch("comidas.json");
        const data = await resp.json();
        
        pintar(data);
        //detBotones(data);
        detBotones(data);
        
    } catch (error) {
        console.log(error)
    }
    
}

//Pintar el carrito con todos los objetos json

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



//Asignar boton detalle

let arrayProducto ={};

const detBotones = (data) =>{
    const botones = document.querySelectorAll(".card button ");
    botones.forEach(btn =>{
        btn.addEventListener('click',()=>{
            const producto = data.find( e => e.id === parseInt(btn.dataset.id));
           
            
            // sumCont()
            // pintarCarrito();

            console.log("funciona"+producto.nombre)
            })
    })
    
}


//Mostrar el detalle del producto

//////////////Mostrar carrito//////////////

const mostCarro = document.querySelector(".card button")
const vistaDetalle = document.querySelector(".detalle")
mostCarro.addEventListener("click",()=>{
    vistaDetalle.style.display = "flex"
})