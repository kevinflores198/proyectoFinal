// Realizar un programa que elimine 
// los dos últimos elementos de un array. Mostrar el
// resultado

let numeros = new Array();

numeros = [1,2,3,4,5,6];
alert(`Array original: ${numeros}`);

numeros.splice(-2);
alert(`Array modificado: ${numeros}`);

