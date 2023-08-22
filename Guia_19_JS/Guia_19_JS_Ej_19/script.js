// Realizar un programa en Java donde se
//  creen dos arreglos: el primero será un arreglo A
// de 50 números reales, y el segundo B,
//  un arreglo de 20 números, también reales. El
// programa deberá inicializar el arreglo
//  A con números aleatorios y mostrarlo por pantalla.
// Luego, el arreglo A se debe ordenar de 
// menor a mayor-------- y copiar los primeros 10 números
// ordenados al arreglo B de 20 elementos, 
// y rellenar los 10 últimos elementos con el valor
// 0.5. Mostrar los dos arreglos resultantes
// : el ordenado de 50 elementos y el combinado
// de 20.

var arreglo1 = new Array();
var arreglo2 = new Array();


for (let i = 0; i < 50; i++) {

    const num = Math.random([i]) * 10;

    arreglo1.push(num.toFixed(2));
};

arreglo1.sort();

for (let i = 0; i < 20; i++) {

    if (i <= 9) {
        arreglo2[i] = arreglo1[i];
    } else if (i <= 19) {
        arreglo2[i] = 0.5;
    }
    
}

console.log(`
Arreglo 1: ${arreglo1}
Arreglo 2: ${arreglo2}`);