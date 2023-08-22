// Conocido el número en matemática PI π, pedir
//  al usuario que ingrese el valor del radio
// de una circunferencia y calcular y mostrar 
// por pantalla el área y perímetro. Recuerde que
// para calcular el área y el perímetro se u
// tilizan las siguientes fórmulas:
// area = PI * radio2
// perimetro = 2 * PI * radio
// Usaremos Math.pow() para usar la potencia
// Usaremos Math.PI para el valor de pi


var radio = prompt("Ingrese el valor del radio para la circunferencia")

var PI = Math.PI;
area = PI * Math.pow(radio, 2);
perimetro = 2 * PI * radio;

alert(
    "El area de la circunferencia es: " + area +
    "\nY el perimetro es: " + perimetro
);
