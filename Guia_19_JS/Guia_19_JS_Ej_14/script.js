// Crear un objeto libro que contenga 
// las siguientes propiedades: ISBN, 
// Título, Autor,
// Número de páginas. Crear un método 
// para cargar un libro pidiendo los datos al usuario
// y luego informar mediante otro 
// método el número de ISBN, el título, 
// el autor del libro y el
// numero de páginas.

var libro = {

    ISBN: 0,
    titulo: "",
    autor: "",
    numeroDePaginas: 0,

    cargar: function () {
        this.ISBN = parseInt(prompt("Cargar el isbn"));
        this.titulo = prompt("Cargar el tituo");
        this.autor = prompt("Cargar el autor");
        this.numeroDePaginas = parseInt(prompt("Cargar el numero de paginas"));
    },

    mostrar: function () {

        alert(`--------LIBRO-------
        ISBN: ${libro.ISBN}
        TITULO: ${libro.titulo}
        AUTOR: ${libro.autor}
        NUMERO DE PAGINAS: ${libro.numeroDePaginas}`)

    }
}

libro.cargar();
libro.mostrar();