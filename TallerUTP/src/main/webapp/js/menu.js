const boton = document.querySelector(".logo__icono");
const lista = document.querySelector(".menu");

boton.addEventListener("click", () =>{
    lista.classList.toggle("nav__toggle");
})
for (let i = 0; i <link.length; i++) {
    link[i].addEventListener("click", () =>{
        for (let j = 0; j < link.length; j++) {
            link[j].style.backgroundColor = "rgb(33, 33, 33)";
        }
        link[i].style.backgroundColor = "#2473cd";
    });
}

