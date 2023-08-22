// Construir un programa que simule un menú
//  de opciones para realizar las cuatro
// operaciones aritméticas básicas (suma, 
//     resta, multiplicación y división) con dos valores
// numéricos enteros. El usuario, además,
//  debe especificar la operación con el primer
// carácter de la operación que desea 
// realizar: ‘S' o ‘s’ para la suma, ‘R’ 
// o ‘r’ para la resta, ‘M’
// o ‘m’ para la multiplicación y ‘D’ o 
// ‘d’ para la división.

var num1 = parseInt(prompt("Ingrese un numero para calcular"));
var num2 = parseInt(prompt("Ingrese otro numero para calcular"));
var suma = num1 + num2;
var resta = (num1 - num2);
var multiplicación = (num1 * num2);
var division = (num1 / num2);

var rta = parseInt(prompt("Ingrese que desea hacer:\n1. Suma\n2. Resta\n3. Multiplicacion\n4. Division\n5. Salir"));

switch (rta) {
    case 1:
        alert(suma);
        break;
    case 2:
        alert(resta);
        break;
    case 3:
        alert(multiplicación);
        break;
    case 4:
        alert(division);
        break;
    default:
        alert("Gracias por ingresar")
        break;
}