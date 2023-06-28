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
      //////////////////////////////Prueba de stock/////////////////////
      if(element.id == 5){
        template.querySelector("button").style.display = "none";
        template.querySelector("#stock").style.display = "";
      }else{
        template.querySelector("button").style.display = "";
        template.querySelector("#stock").style.display = "none";
      }
      /////////////////////////////Fin Prueba de stock/////////////////////////////////////
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
            
               //////////////////////////////Prueba de stock/////////////////////
      if(element.id == 5){
        template.querySelector("button").style.display = "none";
        template.querySelector("#stock").style.display = "";
      }else{
        template.querySelector("button").style.display = "";
        template.querySelector("#stock").style.display = "none";
      }
      /////////////////////////////Fin Prueba de stock/////////////////////////////////////


              
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
            
               //////////////////////////////Prueba de stock/////////////////////
      if(element.id == 5){
        template.querySelector("button").style.display = "none";
        template.querySelector("#stock").style.display = "";
      }else{
        template.querySelector("button").style.display = "";
        template.querySelector("#stock").style.display = "none";
      }
      /////////////////////////////Fin Prueba de stock/////////////////////////////////////



              
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

///////////////////////////////////////////////////////////


