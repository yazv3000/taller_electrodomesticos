const btnAnterior = document.querySelectorAll(".btn__anterior");
const btnSiguiente = document.querySelectorAll(".btn__siguiente");

const contenido = document.querySelectorAll("ul");
var posicion = 0;

for (let i = 0; i < contenido.length; i++) {
	btnSiguiente[i].addEventListener("click", () => {
		posicion += -100;
		if (posicion < -300) {
			posicion = 0;
		}
		//alert(posicion);
		contenido[i].style.marginLeft = `${posicion}%`;
	});

	btnAnterior[i].addEventListener("click", () => {
		if (posicion == 0) {
			posicion = 0;
		} else {
			posicion += 100;
		}
		contenido[i].style.marginLeft = `${posicion}%`;
	});
}

// ===== Boton Mostrar Horas =====

const btnMostrarHoras = document.querySelectorAll(".mostrar__horas");
const tecnicnoHorario = document.querySelectorAll(".tecnico__horario");
const carrusel = document.querySelectorAll(".carrusel");

for (let m = 0; m < btnMostrarHoras.length; m++) {
	btnMostrarHoras[m].addEventListener("click", () => {
		carrusel[m].classList.toggle("carrusel--altura");
		tecnicnoHorario[m].classList.toggle("tecnico__horario--altura");
		btnMostrarHoras.innerHTML = "Menos";
	});
}



