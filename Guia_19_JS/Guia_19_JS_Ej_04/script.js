// Realiza un programa que sólo permita introducir
//  los caracteres ‘S’ y ‘N’. Si el usuario
// ingresa alguno de esos dos caracteres se deberá
//  de imprimir un mensaje por pantalla
// que diga “CORRECTO”, en caso contrario, se deberá
//  imprimir “INCORRECTO”.

var letra = prompt("Ingrese una S o una N").toUpperCase();

if (letra == "S" || letra == "N") {
    alert("CORRECTO");

} else {
    alert("INCORRECTO, la letra ingresada tiene que ser una N o S")
}