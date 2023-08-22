// Escribir una función flecha que reciba una palabra y la devuelva al revés.

var frase = prompt("Ingrese una frase");
var reversa = frase => frase.split("").reverse().join("");

alert(`Usted ingreso esta frase: ${frase}
Asi es como se ve invertida: ${reversa(frase)}`);
