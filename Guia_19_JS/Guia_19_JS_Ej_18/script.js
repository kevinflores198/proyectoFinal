// A partir del siguiente array: var 
// valores = [true, 5, false, "hola", "adios", 2]:
// a) Determinar cual de los dos 
// elementos de texto es mayor
// b) Utilizando exclusivamente los 
// dos valores booleanos del array, determinar los
// operadores necesarios para obtener 
// un resultado true y otro resultado false
// c) Determinar el resultado de las 
// cinco operaciones matemáticas realizadas con los
// dos elementos numéricos

var valores = [true, 5, false, "hola", "adios", 2];
var stringMay;
let palabra_larga = '';

a();
b();
c();

function a() {

    for (let i = 0; i < valores.length; i++) {

        if (valores[i].length > palabra_larga.length) {
            palabra_larga = valores[i];
        }
    }
    alert(`La palabra mas larga es: ${palabra_larga}`);
}

function b() {

    var bool = new Array();

    valores.forEach(v => {
        if (v == true || v == false) {
            bool.push(true);
        } else {
            bool.push(false);
        }
    });

    alert(`Los resultados son: ${bool}`)

}

function c() {

    suma = valores[1] + valores[5];
    resta = valores[1] - valores[5];
    multiplicacion = valores[1] * valores[5];
    dvision = valores[1] / valores[5];

    alert(`Calculos:
    Suma: ${suma}
    Resta: ${resta}
    Multiplicacion: ${multiplicacion}
    Division: ${dvision}`);

}