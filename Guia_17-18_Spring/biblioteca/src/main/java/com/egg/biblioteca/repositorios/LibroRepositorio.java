
package com.egg.biblioteca.repositorios;

import com.egg.biblioteca.entidades.Libro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepositorio  extends JpaRepository<Libro,Long>{ // creamos una interfaz con repository y extendera jpa con un libro y la llave que seria el long id

    //interfaces no tienen cuerpo ni retorno
    
    @Query("SELECT l FROM Libro l WHERE l.titulo = :titulo")
    public Libro buscarPorTitulo(@Param("titulo") String titulo); //Aca jugamos con los titulos, tanto el que pasamos por query como el que esta en la base de datos

    @Query("SELECT l FROM Libro l WHERE l.autor.nombre = :nombre")
    public List<Libro> buscarPorAutor(@Param("nombre") String nombre);


}
