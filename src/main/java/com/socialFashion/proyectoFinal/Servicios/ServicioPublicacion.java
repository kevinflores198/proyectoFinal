package com.socialFashion.proyectoFinal.Servicios;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.socialFashion.proyectoFinal.Entidades.Comentario;
import com.socialFashion.proyectoFinal.Entidades.Imagen;
import com.socialFashion.proyectoFinal.Entidades.Publicacion;
import com.socialFashion.proyectoFinal.Entidades.ReportPublicacion;
import com.socialFashion.proyectoFinal.Entidades.Usuario;
import com.socialFashion.proyectoFinal.Enumeraciones.Categorias;
import com.socialFashion.proyectoFinal.Enumeraciones.ReportsUser;
import com.socialFashion.proyectoFinal.Exceptions.MiException;
import com.socialFashion.proyectoFinal.Repositorios.RepositorioUsuario;

import com.socialFashion.proyectoFinal.Repositorios.RepositorioPublicacion;

import com.socialFashion.proyectoFinal.Repositorios.RepositorioReportePublicacion;

@Service
public class ServicioPublicacion {
    @Autowired
    private ServicioImagen sImg;

    @Autowired
    private RepositorioUsuario repoUser;

    @Autowired
    private RepositorioPublicacion repoPubli;

    @Autowired
    private RepositorioReportePublicacion repoReportePubli;

    @Autowired
    private ServicioComentario servicioComentario;

    @Transactional
    public void crearPublicacion(String idUser, String label, MultipartFile archivo, String content)
            throws MiException {

        validacion(idUser, label, archivo, content);

        Publicacion publicacion = new Publicacion();

        Optional<Usuario> usuarioRespuesta = repoUser.findById(idUser);

        if (usuarioRespuesta.isPresent()) {
            Usuario usuario = new Usuario();
            usuario = usuarioRespuesta.get();

            publicacion.setUser(usuario); // agregar id de usuarios desde repo usuario

            publicacion.setLabel(Categorias.valueOf(label.toUpperCase()));

            Imagen image = new Imagen();
            image = sImg.guardar(archivo);
            publicacion.setImage(image);

            publicacion.setContent(content);
            publicacion.setLikes(0);
            publicacion.setInitialDate(new Date());

            repoPubli.save(publicacion);
        }else{
            throw new MiException("No se encontró el usuario");
        }

    }

    @Transactional
    public void eliminar(String idPublicacion) throws MiException {        

        for (Comentario comentario : servicioComentario.getComentariosByPublicacion(idPublicacion)) {
            servicioComentario.eliminarComentario(comentario.getIdComent());
        }
        for (ReportPublicacion report : repoReportePubli.reportPublicacionByIdPublicacion(idPublicacion)) {
            repoReportePubli.delete(report);
        }
        repoPubli.delete(repoPubli.getById(idPublicacion));

    }

    @Transactional(readOnly=true)
    public List<Publicacion> getPublicacionByUser(String idUser){
        return repoPubli.publicacionesByUser(idUser);
    }

    @Transactional(readOnly=true)
    public List<Publicacion> listaPublicacion(){
        return repoPubli.findAll();
    }

    public Publicacion getOne(String id){
        return repoPubli.getOne(id);
    }

    @Transactional
    public void modificarPublicacion(String label, String idPublicacion, String content) throws MiException {
        if (label == null || label.isEmpty()) {
            throw new MiException("la categoria no puede estar vacia");
        }
        if (content == null) {
            throw new MiException("la descripcion no puede ser nula");
        }

        Optional<Publicacion> rsp = repoPubli.findById(idPublicacion);
        if (rsp.isPresent()) {
            Publicacion publicacion = rsp.get();
            publicacion.setLabel(Categorias.valueOf(label.toUpperCase()));
            publicacion.setContent(content);
            repoPubli.save(publicacion);
        }
    }

    public void validacion(String idUser, String label, MultipartFile archivo, String content) throws MiException {
        if (idUser.isEmpty() || idUser == null) {
            throw new MiException("el id del usuario no puede estar vacio");
        }
        if (label == null || label.isEmpty()) {
            throw new MiException("la categoria no puede estar vacia");
        }
        if (archivo == null || archivo.isEmpty()) {
            throw new MiException("la publicacion tiene que contener una imagen");
        }
        if (content == null) {
            throw new MiException("la descripcion no puede ser nula");
        }
    }
    
    @Transactional
    public void agregarLike(String id){
        Publicacion publicacion = getOne(id);
        Integer suma = publicacion.getLikes() + 1;
        publicacion.setLikes(suma);
    }
    
    @Transactional
    public void sacarLike(String id){
        Publicacion publicacion = getOne(id);
        Integer suma = publicacion.getLikes() - 1;
        publicacion.setLikes(suma);
    }
    
    public List<Publicacion> topDiez(){
        return repoPubli.listaTopDiez().subList(0, 9);
    }
}
