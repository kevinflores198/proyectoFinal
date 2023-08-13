package com.socialFashion.proyectoFinal.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialFashion.proyectoFinal.Entidades.Imagen;

/**
 * repositorioImangen
 */
@Repository
public interface repositorioImangen extends JpaRepository<Imagen, String>{

}