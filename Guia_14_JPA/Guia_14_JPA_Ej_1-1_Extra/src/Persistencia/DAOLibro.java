package Persistencia;

import entidades.Autor;
import entidades.Editorial;
import entidades.Libro;
import java.util.List;
import java.util.Scanner;

public class DAOLibro extends DAO<Libro> {

    Scanner leer = new Scanner(System.in);
    Libro libro = new Libro();

    public void guardarLibro(Libro libro) {
        super.guardar(libro);
    }

    public void editarLibro(Libro libro) {
        super.editar(libro);
    }

    public void eliminarLibro(Libro libro)  {
        super.eliminar(libro);
    }

    public Libro buscarLibro(Long isbn) {
        super.conectar();
        Libro libro = em.find(Libro.class, isbn);
        super.desconectar();
        return libro;
    }
    
    public Libro buscarLibroTitulo(String titulo) {
        super.conectar();
        Libro libro = em.find(Libro.class, titulo);
        super.desconectar();
        return libro;
    }
    
    public Libro buscarLibroPorAutor(Autor autor) {
        super.conectar();
        Libro libro = em.find(Libro.class, autor.getNombre());
        super.desconectar();
        return libro;
    }
    
    public Libro buscarLibroPorEditorial(Editorial editorial) {
        super.conectar();
        Libro libro = em.find(Libro.class, editorial.getNombre());
        super.desconectar();
        return libro;
    }

    public List<Libro> listarLibros() {
        super.conectar();
        List<Libro> libros = em.createQuery("select l from Libro l").getResultList();
        super.desconectar();
        return libros;
    }

}
