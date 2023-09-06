package com.socialFashion.proyectoFinal.Servicios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

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
        
        System.out.println(idUser);
        System.out.println(label);
        System.out.println(content);
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
        return repoPubli.getById(id);
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
        }
    }

    public void validacion(String idUser, String label, MultipartFile archivo, String content) throws MiException {
        if (idUser == null || idUser.isEmpty()) {
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
    
    // -------- Funciones de Me Gustas ---------
    @Transactional
    public void Like(String id, Usuario usuarioLike) {
        Publicacion publicacion = getOne(id);

        List<Usuario> usuarios = repoPubli.publicacionById(id).getUsuarioLikes();
        List<Usuario> usuariosAux = usuarios;
        int indexToDelete = usuarios.size();
        boolean encontrado = false;
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario usuario = usuarios.get(i);
            if (usuario.getId().equals(usuarioLike.getId())) {
                encontrado = true;
                indexToDelete = i;
                break;
            }
        }

        if ((!encontrado) || usuarios.size() == 0) {
            usuariosAux.add(usuarioLike);
            publicacion.setLikes(publicacion.getLikes() + 1);
        } else {
            usuariosAux.remove(indexToDelete);
            publicacion.setLikes(publicacion.getLikes() - 1);
        }
        publicacion.setUsuarioLikes(usuariosAux);
        
        repoPubli.save(publicacion);
    }

    /* -------- Funciones de Lectura en la BD --------- */
    
    /**
     * trae las 10 publicaciones con más me gusta
     */
    @Transactional(readOnly=true)
    public List<Publicacion> topDiez(){
        // ------- LISTA DE TOP BY COMMENT Y LIKES --------
        List<Publicacion> publicaciones = repoPubli.listaTop();
        // ----------------- LISTA FINAL ------------------
        List<Publicacion> topDiez = new ArrayList<>();

        Date hoy = new Date();  // Dia de hoy para comparar
        for (Publicacion publicacion : publicaciones) {

            long tiempoTrascurrido = hoy.getTime() - publicacion.getInitialDate().getTime();
            TimeUnit unidad = TimeUnit.DAYS;

            long dias = unidad.convert(tiempoTrascurrido, TimeUnit.MILLISECONDS);
            if(dias <= 7){
                topDiez.add(publicacion);
            }
        }
        if(topDiez.size() > 10){
            return topDiez.subList(0, 9);
        }
        return topDiez;
    }
    
    /**
     * trae las publicaciones con más me gusta
     */
    @Transactional(readOnly=true)
    public List<Publicacion> topPublicacion(){
        return repoPubli.listaTop();
    }
    
    /**
     * trae las publicaciones ordenadas de manera ascendente
     * por fecha
     */
    @Transactional(readOnly=true)
    public List<Publicacion> publicacionesPorFechaASC(){
        return repoPubli.publicacionesByDateAsc();
    }
    
    /**
     * trae las publicaciones ordenadas de manera descendente
     * por fecha
     */
    @Transactional(readOnly=true)
    public List<Publicacion> publicacionesPorFechaDESC(){
        return repoPubli.publicacionesByDateDesc();
    }
    
    /**
     * trae las publicaciones por categoria
     * @param:Categoria
     */
    @Transactional(readOnly=true)
    public List<Publicacion> publicacionesPorLabel(Categorias categoria){
        return repoPubli.publicacionesByLabel(categoria);
    }
    
    /**
     * trae las publicaciones ordenadas de manera ascendente
     * por nombre de diseñador
     */
    @Transactional(readOnly=true)
    public List<Publicacion> publicacionesPorNombreDiseñadorASC(){
        return repoPubli.findAllOrderByNombreDiseñadorAsc();
    }
    
    /**
     * trae las publicaciones ordenadas de manera descendente
     * por nombre de diseñador
     */
    @Transactional(readOnly=true)
    public List<Publicacion> publicacionesPorNombreDiseñadorDESC(){
        return repoPubli.findAllOrderByNombreDiseñadorDesc();
    }

    public List<Publicacion> publicacionesPorFiltro(Integer filtro, Categorias categoria){

        switch(filtro){
            case 1:
                if(publicacionesPorLabel(categoria).size() > 10){
                    return publicacionesPorLabel(categoria).subList(0, 9);
                }
                return publicacionesPorLabel(categoria);
            case 2:
                if(publicacionesPorFechaASC().size() > 10){
                    return publicacionesPorFechaASC().subList(0, 9);
                }
                return publicacionesPorFechaASC();
            case 3:
                if(publicacionesPorFechaDESC().size() > 10){
                    return publicacionesPorFechaASC().subList(0, 9);
                }
                return publicacionesPorFechaDESC();
            case 4:
                if(publicacionesPorNombreDiseñadorASC().size() > 10){
                    return publicacionesPorNombreDiseñadorASC().subList(0, 9);
                }
                return publicacionesPorNombreDiseñadorASC();
            case 5:
                if(publicacionesPorNombreDiseñadorDESC().size() > 10){
                    return publicacionesPorNombreDiseñadorDESC().subList(0, 9);
                }
                return publicacionesPorNombreDiseñadorDESC();
        }
        return topDiez();
    }
}
