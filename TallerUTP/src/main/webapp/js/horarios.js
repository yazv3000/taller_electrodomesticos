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
const tecnicoHorario = document.querySelectorAll(".tecnico__horario");
const carruselEspacio = document.querySelectorAll(".carrusel__espacio");

var btnHoras = true;

for (let m = 0; m < btnMostrarHoras.length; m++) {
	btnMostrarHoras[m].addEventListener("click", () => {
		carruselEspacio[m].classList.toggle("carrusel__espacio--altura");
		tecnicoHorario[m].classList.toggle("tecnico__horario--altura");

		if (btnHoras){
			btnHoras = false;
			btnMostrarHoras[m].innerHTML = "Menos";
		} else {
			btnMostrarHoras[m].innerHTML = "Mostrar mas Horas";
			btnHoras = true;
		}
		
	});
}



