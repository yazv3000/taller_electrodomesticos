const boton = document.querySelector(".logo__icono");
const lista = document.querySelector(".menu");

boton.addEventListener("click", () =>{
    lista.classList.toggle("nav__toggle");
})

