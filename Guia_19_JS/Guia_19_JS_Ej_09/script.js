// Realizar un programa que pida una 
// frase y el programa deberá mostrar la frase con un
// espacio entre cada letra. La frase 
// se mostrara así: H o l a. Nota: recordar el
// funcionamiento de la función Substring().

var frase = prompt("Ingrese una frase");
var espacio = ""; //la definimos sin ningun valor

//usaremos un for y charAt para que por cada caracter que lea de la frase a la siguiente le sume un espacio
for (let i = 0; i < frase.length; i++) {
    espacio+= frase.charAt(i) + " ";
}

alert(espacio);