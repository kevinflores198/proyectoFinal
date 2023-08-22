// Realizar un programa que rellene dos 
// vectores al mismo tiempo, con 5 valores aleatorios
// y los muestre por pantalla.

var vector1 = [];
var vector2 = [];

for (let i = 0; i < 5; i++) {
    const num = Math.random([i]) * 10;
    vector1.push(num.toFixed(2));

    const num1 = Math.random([i]) * 10;
    vector2.push(num1.toFixed(2));

};

alert(`
vector 1: ${vector1}
vector 2: ${vector2}`);