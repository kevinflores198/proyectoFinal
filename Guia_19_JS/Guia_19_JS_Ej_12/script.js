// Escribir una función flecha de
//  JavaScript que reciba un argumento y retorne el tipo de
// dato.

ingresar();

function ingresar() {
    let tipo = prompt("Ingrese algo");
if (tipo == "true" || tipo == "false" || tipo.includes("0") || tipo.includes("1") || tipo.includes("2") || tipo.includes("3") ||
    tipo.includes("4") || tipo.includes("5") || tipo.includes("6") || tipo.includes("7") || tipo.includes("8") || tipo.includes("9")) {
    tipo = JSON.parse(tipo);
}

alert(typeof tipo);
}
