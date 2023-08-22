package com.egg.biblioteca.servicios;

import com.egg.biblioteca.entidades.Autor;
import com.egg.biblioteca.entidades.Editorial;
import com.egg.biblioteca.entidades.Libro;
import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.repositorios.AutorRepositorio;
import com.egg.biblioteca.repositorios.EditorialRepositorio;
import com.egg.biblioteca.repositorios.LibroRepositorio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroServicio {
    
    @Autowired //Inyeccion de dependencia, le avisa que tiene que iniciar la variable
    private LibroRepositorio libroRepositorio;
    
    @Autowired
    private AutorRepositorio autorRepositorio;
    
    @Autowired
    private EditorialRepositorio editorialRepositorio;

    //crear un libro
    @Transactional //Todos los metodos que generen un cambio en la base de datos tienen que ser transaccionales
    public void crearLibro(
            Long isbn,
            String titulo,
            Integer ejemplares,
            String idAutor,
            String idEditorial) throws MiException {

        validar(isbn, titulo, ejemplares, idAutor, idEditorial);
        
        Autor autor = autorRepositorio.findById(idAutor).get();
        Editorial editorial = editorialRepositorio.findById(idEditorial).get();
        
        Libro libro = new Libro();
        
        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setEjemplares(ejemplares);
        libro.setAlta(new Date());
        
        libro.setAutor(autor);
        libro.setEditorial(editorial);
        
        libroRepositorio.save(libro); //Una vez instanciada podemos usar el repo y guardar todo en la base de datos, en este ejemplo guarda un (libro)

    }
    
    public List<Libro> listarLibro() {
        
        List<Libro> libros = new ArrayList(); //HAcemos una lista de libros y lo igualamos al repositorio para poder recibir la informacion

        libros = libroRepositorio.findAll();
        
        return libros;
    }

    //editar un libro
    @Transactional
    public void modificarLibro(
            Long isbn,
            String titulo,
            Integer ejemplares,
            String idAutor,
            String idEditorial
            ) throws MiException {
        //Si tenemos uin error en lo que ingrese el cliente no podremos usar este = Libro libro = libroRepositorio.findById(isbn).get();

        validar(isbn, titulo, ejemplares, idAutor, idEditorial);
        
        Optional<Libro> respuesta = libroRepositorio.findById(isbn); //Objeto contenedor que puede tener un oebjeto not null
        Optional<Autor> respuestaAutor = autorRepositorio.findById(idAutor);
        Optional<Editorial> respuestaEditorial = editorialRepositorio.findById(idAutor);
        
        Autor autor = new Autor();
        Editorial editorial = new Editorial();
        
        if (respuestaAutor.isPresent()) {
            
            autor = respuestaAutor.get();
        }
        
        if (respuestaEditorial.isPresent()) {
            
            editorial = respuestaEditorial.get();
        }
        
        if (respuesta.isPresent()) {
            
            Libro libro = respuesta.get();
            
            libro.setTitulo(titulo);
            
            libro.setAutor(autor);
            
            libro.setEditorial(editorial);
            
            libro.setEjemplares(ejemplares);
            
            libroRepositorio.save(libro);
        }
    }
    
    public Libro getOne(Long id) {
        return libroRepositorio.getOne(id);
    }
    
    private void validar(Long isbn, String titulo, Integer ejemplares, String idAutor, String idEditorial) throws MiException{
        if (isbn == null) {
            throw new MiException("\nEl isbn no puede ser nulo");
        }
        if (titulo.isEmpty() || titulo == null) {
            throw new MiException("\nEl titulo no puede ser nulo o estar vacio");
        }
       if (ejemplares == null) {
            throw new MiException("\nejemplares no puede ser nulo");
        }
        if (idAutor.isEmpty() || idAutor == null) {
            throw new MiException("\nEl id del autor no puede ser nulo o estar vacio");
        }
        if (idEditorial.isEmpty() || idEditorial == null) {
            throw new MiException("\nEl id de la editorial no puede ser nulo o estar vacio");
        }
    }

    //permitir habilitar un libro
}
