// Realizar un programa que obtenga la 
// siguiente matriz [[3], [6], [9], [12], [15]] y devuelve y
// muestre el siguiente array [6, 9, 12, 15, 18].

var matriz = new Array();

matriz = [[3], [6], [9], [12], [15]];

matriz = matriz.flat();

var vec = new Array();

for (let i = 0; i < matriz.length; i++) {

    vec[i] = matriz[i] + 3;

}

console.log(`Resultado = ${matriz}
Nuevo = ${vec}`)