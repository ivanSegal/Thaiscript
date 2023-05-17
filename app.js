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
const botTodo = document.querySelector("#todo")
botTodo.addEventListener("click",()=>{
    console.log("Todo")
})

const botPri = document.querySelector("#principal")
botPri.addEventListener("click",()=>{
    //console.log("principal")
    
})

const botGuar = document.querySelector("#guarnicion")
botGuar.addEventListener("click",()=>{
    console.log("Guarnición")
})



//Pintar la pagina principal principal

const contenedorProo = document.querySelector("#contenedor-principal");
const contenedorGua = document.querySelector("#contenedor-guarnicion");

const pintarSele = data1 =>{
    const template = document.querySelector("#template-productos").content;
    const fragment = document.createDocumentFragment();
    const fragmentGua = document.createDocumentFragment();
    //recorrer arreglo de objetos
    console.log(data1)
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
    
            fragment.appendChild(clone)
        } else{
            template.querySelector("img").setAttribute("src",element.thumbnailUrl);
            template.querySelector("h5").textContent = element.nombre;
            template.querySelector("span").textContent = element.precio;
            template.querySelector("button").dataset.id = element.id;
    
            template.querySelector(".parra").textContent = element.decripcion;
            template.querySelector(".ingr").textContent = element.ingredientes;
    
            template.querySelector(".colbu").setAttribute("data-bs-target",element.target);
            template.querySelector(".collapse").setAttribute("id",element.idd)
    
            
            const clone = template.cloneNode(true)
    
            fragmentGua.appendChild(clone)
        }
       
    });
    contenedorProo.appendChild(fragment)
    contenedorGua.appendChild(fragmentGua)
}



