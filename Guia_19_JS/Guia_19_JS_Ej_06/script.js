// Realizar un programa que, dado 
// un número entero, visualice 
// en pantalla si es par o impar.
// En caso de que el valor ingresado
//  sea 0, se debe mostrar “el 
//  número no es par ni impar”.

var numero = parseInt(prompt("Ingrese un numero"))

if (numero%2==0) {
    alert("El numero ingresado es par")
}else{
    alert("El numero ingresado es impar")
}