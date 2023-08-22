// Resalte todas las palabras de más
// de 8 caracteres en el texto del párrafo (con un fondo
// amarillo, por ejemplo)

let parrafo = document.getElementById("texto");

let palabra = parrafo.innerHTML.split(" ");

for (let i = 0; i < palabra.length; i++) {
    if (palabra[i].length > 8) {

        palabra[i] = "<span class=  'amarillo' > " + palabra[i] + "</span>";
    }
}

parrafo.innerHTML = palabra.join(" ");