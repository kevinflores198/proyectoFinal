// Escribir un programa para obtener un array 
// de las propiedades 
// de un objeto Persona.
// Las propiedades son nombre, edad, sexo 
// ('H' hombre, 'M' mujer, 'O' otro), peso y altura.

var personas = [
    {
        nombre: prompt("Ingrese nombre: "),
        edad: prompt("Ingrese edad: "),
        sexo: prompt("sexo: (H/M/O)"),
        peso: prompt("Ingrese peso"),
        altura: prompt("Ingrese altura")
    },
];

personas.forEach((e)=>console.log(e));