// Crear un objeto persona, con las propiedades nombre, edad
// , sexo ('H' hombre, 'M' mujer,
// 'O' otro), peso y altura. A 
// continuación, muestre las propiedades
//  del objeto JavaScript.

var persona = {
    nombre: prompt("Ingrese el nombre"),
    edad: parseInt(prompt("Ingrese su edad")),
    sexo: prompt("Ingrese el sexo: H: Hombre/M: Mujer/O: Otro"),
    peso: parseFloat(prompt("Ingrese su peso")),
    altura: parseFloat(prompt("Ingrese la altura"))
}

alert(`Persona: 
Nombre: ${persona.nombre}
Edad: ${persona.edad}
Sexo: ${persona.sexo}
Peso: ${persona.peso}
Altura: ${persona.altura}`);