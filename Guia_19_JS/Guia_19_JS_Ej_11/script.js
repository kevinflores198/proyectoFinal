// Escribir una función que reciba un 
// String y devuelva la palabra más larga.
// String Ejemplo: “Guia de JavaScript”
// Resultado esperado : “JavaScript”


ingresarPalabra();

function ingresarPalabra(){

const frase = prompt("Ingrese una frase");

const palabraMasLarga = frase =>{

    const palabra = cadena.split(" ");
    let palabraMasLarga = "";

    palabra.forEach(palabra => {

        if (palabra.length > palabraMasLarga.length) {
            palabraMasLarga = palabra;
        }

    });
    return palabraMasLarga;
}

const resultado = palabraMasLarga(frase);

alert(resultado);
}
