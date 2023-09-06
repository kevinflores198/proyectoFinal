package com.socialFashion.proyectoFinal.Servicios;

import com.socialFashion.proyectoFinal.Entidades.Comentario;
import com.socialFashion.proyectoFinal.Entidades.Publicacion;
import com.socialFashion.proyectoFinal.Entidades.ReportComentario;
import com.socialFashion.proyectoFinal.Exceptions.MiException;

 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
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

    @Lazy // Cuando las beans forman un Cycle
    @Autowired
    private ServicioUsuario servicioUsuario;

    @Transactional
    public void crearComentario(String idUser, String idPublicacion,String comment ) throws MiException {
        validarComentario(idUser, idPublicacion, comment);
        Comentario comentario = new Comentario ();
        
        comentario.setUser(servicioUsuario.getOne(idUser));
        
        Optional<Publicacion> respuesta = repositorioPublicacion.findById(idPublicacion);
        if(respuesta.isPresent()){
            Publicacion publicacion = respuesta.get();
            comentario.setPublicacion(publicacion);
        } else {
            throw new MiException ("no existe una públicacion con ese ID"); 
        } 
        comentario.setComment(comment);

        repositorioComentario.save(comentario);

        agregarComentario(comentario.getIdComent());
    }

    @Transactional
    public void modificarComentario(String idComent, String comment) throws MiException{
        if(comment.isEmpty() || comment == null){
            throw new MiException("el comentario no puede estar vacio");
        }
        repositorioComentario.getById(idComent).setComment(comment);

        repositorioComentario.save(repositorioComentario.getById(idComent));
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
        sacarComentario(idComent);
        repositorioComentario.deleteById(idComent);
    }

    // -------- Funciones al comentar ---------
    @Transactional
    public void agregarComentario(String id){
        Comentario comentario = getOne(id);
        Publicacion publicacion = comentario.getPublicacion();
        publicacion.setComentarios(publicacion.getComentarios() + 1);
    }
    
    @Transactional
    public void sacarComentario(String id){
        Comentario comentario = getOne(id);
        Publicacion publicacion = comentario.getPublicacion();
        publicacion.setComentarios(publicacion.getComentarios() - 1);
    }
    
 public void validarComentario(String idUsuario, String idPublicacion, String comment) throws MiException {
        if (idUsuario == null || idUsuario.isEmpty()) {
            throw new MiException("el idUsuario no puede estar vacío");
        }
        if (idPublicacion == null || idPublicacion.isEmpty()) {
            throw new MiException("el idPublicacion no puede estar vacío");
        }
        if (comment == null || comment.isEmpty()) {
            throw new MiException("el comentario no puede estar vacío");
        }
        
    }
}
