// Escriba un programa en el cual se
//  ingrese un valor límite positivo, y a continuación
// solicite números al usuario hasta 
// que la suma de los números introducidos supere el
// límite inicial.

var limite=0,numero,contador=0;

limite = parseInt(prompt("Ingrese un numero limite a sumar: "));

while (contador <= limite) {
   numero = parseInt(prompt("Ingrese un numero a sumar"));

   contador = contador + numero;
}
alert("Haz superado el limite");
