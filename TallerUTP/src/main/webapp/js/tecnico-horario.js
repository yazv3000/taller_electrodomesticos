

const btnAnterior = document.querySelector(".btn-anterior");
const btnSiguiente = document.querySelector(".btn-siguiente");

const contenido = document.querySelector(".carrusel");
var posicion = 0;


	btnSiguiente.addEventListener("click", () => {
		posicion += -100;
		if (posicion < -300) {
			posicion = 0;
		}
		//alert(posicion);
		contenido.style.marginLeft = `${posicion}%`;
	});

	btnAnterior.addEventListener("click", () => {
		if (posicion == 0) {
			posicion = 0;
		} else {
			posicion += 100;
		}
		contenido.style.marginLeft = `${posicion}%`;
	});
