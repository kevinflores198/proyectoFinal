// //----------------------------- Entrada y salida de datos

// var edad = prompt("Que edad tenes?",34);
// alert("hola, soy un alert, tu edad es " + edad);

// //----------------------------- Tipos de datos en JS

// var edad = prompt("Que edad tenes", 23);

// var numero = 123;

// numero = "123";

// alert("hola, tu edad es: " + edad);

// //----------------------------- JSON

// var persona = {
//     apellido: "flores",
//     nombre: "kevin",
//     nacimiento: new Date("01-03-2002"),
//     dni: 11212121,
//     mascotas: [
//         {
//             apodo: "chiquito",
//             nombreIdentificatorio: 121212,
//             nacimiento: new Date("01-02-2005")
//         },{
//             apodo: "malva",
//             nombreIdentificatorio: 3443434,
//             nacimiento: new Date("01-02-2006")
//         }
//     ]
// };

// class Mascota{
//     apodo;
//     numeroId;

// }

// var m = new Mascota();

// m.apodo = "filomena";
// m.numeroId = 2323;
// console.log(m.numeroId);

//----------------------------- arrays []


// var personas = [
//     {
//         nombre: "Kevin",
//         apellido: "flores",
//     },
//     {
//         nombre : "Lourdes",
//         apellido: "machuca"
//     },
//     {
//         nombre: "Pablo",
//         apellido: "Nose"
//     }
// ];

// //mejor forma de mostrar el ultimo objeto de un array.
// //Usar [array.length-1]
// console.log(personas[personas.length-1 ])

//----------------------------- Funciones en arrays
// var numeros = [1,2,3,4,5,6,7,8];

// var personas = [
//     {
//         nombre: "Kevin",
//         apellido: "flores",
//     },
//     {
//         nombre : "Lourdes",
//         apellido: "machuca"
//     },
//     {
//         nombre: "Pablo",
//         apellido: "Nose"
//     }
// ];

// //como mostrar todos del array
// personas.forEach((e)=>console.log(e));

// //para elegir que variable del objeto mostrar
// personas.forEach((e)=>console.log(e.nombre));

// //usando template string
// personas.forEach((e)=>console.log(e.nombre +" :persona"));

// //como usar el filter, nos toma el array y filtra a los numeros pares.
// numeros.filter((e) => e%2==0)

// //Asi multiplicamos todos los numeros por el numero que deseemos
// numeros.map((e) => e*3)

// //como filtrar con un if para mostrar lo que deseamos

// personas.filter(
//     function(e){
//         if(e.nombre == "Kevin")
//         return e;
//     }
// )

//----------------------------- Conjuntos de datos set y map

//cuando tenemos numeros duplicados
// var numeros = [1,1,1,2,2,3,4,4,4,5,5,6,6];
// //el set no puede tomar variables repetidas y las elimina directamente
// new Set(numeros);

// //split separa letra por letra
// "aaasassssassssaaaa".split("")
// //set split separa todo lo repetido
// new Set("aaasassssassssaaaa".split(""))
