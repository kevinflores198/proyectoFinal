package com.socialFashion.proyectoFinal.repositorios;
import com.socialFashion.proyectoFinal.Entidades.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioComentario extends JpaRepository<Comentario, String> {
    
}

