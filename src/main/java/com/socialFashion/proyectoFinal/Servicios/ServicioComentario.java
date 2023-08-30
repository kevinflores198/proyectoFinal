package com.socialFashion.proyectoFinal.Servicios;

import com.socialFashion.proyectoFinal.Entidades.Comentario;
import com.socialFashion.proyectoFinal.Entidades.Publicacion;
import com.socialFashion.proyectoFinal.Entidades.ReportComentario;
import com.socialFashion.proyectoFinal.Exceptions.MiException;

 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.socialFashion.proyectoFinal.Repositorios.RepositorioComentario;
import com.socialFashion.proyectoFinal.Repositorios.RepositorioPublicacion;
import com.socialFashion.proyectoFinal.Repositorios.RepositorioReporteComentario;

import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicioComentario {
    
    @Autowired
    private RepositorioComentario repositorioComentario;

    @Autowired
    private RepositorioPublicacion repositorioPublicacion;

    @Autowired
    private RepositorioReporteComentario repoReporteComentario;

    @Transactional
    public void crearComentario(String idUser, String idPublicacion,String comment ) throws MiException {
        validarComentario(idUser, idPublicacion, comment);
        Comentario comentario = new Comentario ();
        comentario.setIdUser(idUser);
        
        Optional<Publicacion> respuesta = repositorioPublicacion.findById(idPublicacion);
        if(respuesta.isPresent()){
            Publicacion publicacion = respuesta.get();
            comentario.setPublicacion(publicacion);
           
        } else {
            throw new MiException ("No existe públicacion con ese ID"); 
        } 
        comentario.setComment(comment);
    }
    
    @Transactional(readOnly=true)
    public List<Comentario> getComentariosByPublicacion(String idPublicacion){
        return repositorioComentario.comentariosByIdPublicacion(idPublicacion);
    }

    @Transactional(readOnly=true)
    public List<Comentario> obtenerTodosLosComentarios() {
        return repositorioComentario.findAll();
    }

    public Comentario getOne(String id){
        return repositorioComentario.getOne(id);
    }

    public Optional<Comentario> obtenerComentarioPorId(String idComent) {
        return repositorioComentario.findById(idComent);
    }

    public void eliminarComentario(String idComent) {
        for (ReportComentario reportComentario : repoReporteComentario.reportComentarioByIdComentario(idComent)) {
            repoReporteComentario.delete(reportComentario);
        }
        repositorioComentario.deleteById(idComent);
    }
    
 public void validarComentario(String idUsuario, String idPublicacion, String comment) {
        if (idUsuario == null || idUsuario.isEmpty()) {
            throw new IllegalArgumentException("El idUsuario no puede estar vacío");
        }
        if (idPublicacion == null || idPublicacion.isEmpty()) {
            throw new IllegalArgumentException("El idPublicacion no puede estar vacío");
        }
        if (comment == null || comment.isEmpty()) {
            throw new IllegalArgumentException("El comentario no puede estar vacío");
        }
        
    }
}
