const abrirModal = document.querySelector('.nav__sesion');

const modal = document.querySelector('.modal__sesion');

const cerrarModal = document.querySelector('.modal__cerrar')

abrirModal.addEventListener("click",(e)=>{
    e.preventDefault();
    modal.classList.add('modal--mostrar');
});

cerrarModal.addEventListener("click",(e)=>{
    e.preventDefault();
    modal.classList.remove('modal--mostrar');
});


// ===== BOOTSTRAP =====

(function () {
  'use strict'

  // Fetch all the forms we want to apply custom Bootstrap validation styles to
  var forms = document.querySelectorAll('.needs-validation')

  // Loop over them and prevent submission
  Array.prototype.slice.call(forms)
    .forEach(function (form) {
      form.addEventListener('submit', function (event) {
        if (!form.checkValidity()) {
          event.preventDefault()
          event.stopPropagation()
        }

        form.classList.add('was-validated')
      }, false)
    })
})()