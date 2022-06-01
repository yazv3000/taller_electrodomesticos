const btnBarras = document.querySelector(".nav__barras");
const lista = document.querySelector(".nav__lista");


btnBarras.addEventListener("click",(e)=>{
    e.preventDefault();
    lista.classList.toggle("nav__lista--ocultar");
});