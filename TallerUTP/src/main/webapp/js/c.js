
const numero = document.querySelector(".numero").innerHTML;
let numeroSerie = document.querySelector(".electro__serie");
const btnAceptar = document.querySelector(".boton");
let serie = document.querySelector(".num-serie").innerHTML;

// MARCA
let marca = document.querySelectorAll(".select-marca");
let etqMarca = document.querySelector(".etq-marca");

// TIPO
let tipo = document.querySelectorAll(".select-tipo");
let etqTipo = document.querySelector(".etq-tipo");

// MODELO
let modelo = document.querySelector(".input-modelo");
let etqModelo = document.querySelector(".etq-modelo");



btnAceptar.addEventListener('click', () => {
	serie = document.querySelector(".num-serie").innerHTML = numeroSerie.value;
	
	etqModelo.innerHTML = modelo.value;
	
	for (var i = 0; i < marca.length; i++) {
		if (marca[i].selected) {
			etqMarca = document.querySelector(".etq-marca").innerHTML = marca[i].innerHTML;
		}
	}
	
	for (var m = 0; m < tipo.length; m++) {
		if (tipo[m].selected) {
			etqTipo = document.querySelector(".etq-tipo").innerHTML = tipo[m].innerHTML;
		}
	}
	
});




//alert(marca[2].innerHTML)