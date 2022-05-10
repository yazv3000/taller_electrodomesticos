const campoNumerico = document.getElementById('campo-numerico');

campoNumerico.addEventListener('keydown', function(evento) {
  const teclaPresionada = evento.key;
  const teclaPresionadaEsUnNumero =
    Number.isInteger(parseInt(teclaPresionada));

  const sePresionoUnaTeclaNoAdmitida = 
    teclaPresionada != 'ArrowDown' &&
    teclaPresionada != 'ArrowUp' &&
    teclaPresionada != 'ArrowLeft' &&
    teclaPresionada != 'ArrowRight' &&
    teclaPresionada != 'Backspace' &&
    teclaPresionada != 'Delete' &&
    teclaPresionada != 'Enter' &&
    !teclaPresionadaEsUnNumero;
  const comienzaPorCero = 
    campoNumerico.value.length === 0 &&
    teclaPresionada == 0;

  if (sePresionoUnaTeclaNoAdmitida || comienzaPorCero) {
    evento.preventDefault(); 
  }

});

const campoNumerico2 = document.getElementById('cant');

campoNumerico2.addEventListener('keydown', function(evento) {
  const teclaPresionada = evento.key;
  const teclaPresionadaEsUnNumero =
    Number.isInteger(parseInt(teclaPresionada));

  const sePresionoUnaTeclaNoAdmitida = 
    teclaPresionada != 'ArrowDown' &&
    teclaPresionada != 'ArrowUp' &&
    teclaPresionada != 'ArrowLeft' &&
    teclaPresionada != 'ArrowRight' &&
    teclaPresionada != 'Backspace' &&
    teclaPresionada != 'Delete' &&
    teclaPresionada != 'Enter' &&
    !teclaPresionadaEsUnNumero;
  const comienzaPorCero = 
    campoNumerico2.value.length === 0 &&
    teclaPresionada == 0;

  if (sePresionoUnaTeclaNoAdmitida || comienzaPorCero) {
    evento.preventDefault(); 
  }

});

