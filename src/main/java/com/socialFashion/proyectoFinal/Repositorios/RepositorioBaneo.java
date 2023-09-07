package com.socialFashion.proyectoFinal.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.socialFashion.proyectoFinal.Entidades.Baneo;


@Repository
public interface RepositorioBaneo extends JpaRepository<Baneo,String> {
    
    @Query("SELECT b FROM Baneo b WHERE b.user.id = :idUser")
    public Baneo banByUser(@Param("idUser") String idUser);

}
