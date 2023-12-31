package com.socialFashion.proyectoFinal.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.socialFashion.proyectoFinal.Entidades.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, String> {

    @Query("SELECT u FROM Usuario u WHERE u.name = :name")
    public Usuario searchByUsername(@Param("name")String name);
}
