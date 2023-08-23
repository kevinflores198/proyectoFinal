package com.socialFashion.proyectoFinal.Repositorios;
import com.socialFashion.proyectoFinal.Entidades.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface RepositorioComentario extends JpaRepository<Comentario,String> {
    
    @Query("SELECT c FROM Comentario p WHERE c.idComent = :idComent")
    public Comentario comentario(@Param("idComent")String idComent);
    
}