// 24. Escribir un programa de JavaScript 
// que a través de un formulario calcule el radio de un
// circulo y lo muestre en el HTML.

let form = document.getElementById("form");

form.addEventListener("submit", calcularRadio);

function calcularRadio(e) {

    e.preventDefault();

    let diametro = form.elements["diametro"].value;

    let radio = diametro / 2;

    document.getElementById("resultado").innerHTML = `El radio es: ${radio}`;

    return false;
}
