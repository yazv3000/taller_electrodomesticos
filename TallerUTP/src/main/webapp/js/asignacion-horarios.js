const btn = document.querySelector(".boton-check");
const check = document.querySelectorAll(".tecnico-check");

btn.addEventListener("click", () =>{

	for (let i=0; i< check.length; i++){
		check[i].checked = true;
	}
})
