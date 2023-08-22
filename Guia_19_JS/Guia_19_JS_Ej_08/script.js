// Escribir un programa que lea números
//  enteros hasta teclear 0 (cero). Al finalizar el
// programa se debe mostrar el máximo 
// número ingresado, el mínimo, y el promedio de
// todos ellos.

// Definir variables iniciales
let numero = parseInt(prompt("Ingresa un número entero (ingresa 0 para terminar):"));
let maximo = numero;
let minimo = numero;
let suma = numero;
let contador = 1;

while (numero !== 0) {
    numero = parseInt(prompt("Ingresa otro numero (ingresa 0 para terminar):"));

    if (numero !== 0) {

        if (numero > maximo) {
            maximo = numero;
        }
        if (numero < minimo) {
            minimo = numero;
        }

        suma += numero;
        contador++;
    }
}

const promedio = suma / contador;

alert(`Maximo numero ingresado: ${maximo}
Minimo numero ingresado: ${minimo}
Promedio de todos los numeros ingresados: ${promedio}`);
document.write(`Maximo numero ingresado: ${maximo}
Minimo numero ingresado: ${minimo}
Promedio de todos los numeros ingresados: ${promedio}`);




