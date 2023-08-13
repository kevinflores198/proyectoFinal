package com.socialFashion.proyectoFinal.Entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

/**
 *Entidad Comentario
 */
@Entity
public class Comentario {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idComent;

    private String idUser;

    @ManyToOne
    private Publicacion publicacion;

    private String comment;
    private Boolean alta;

    //@OneToMany            No se usa
    //private ArrayList<ReportComentario> reports;
    
    public Comentario() {
    }

    public Comentario(String idUser, Publicacion publicacion, String comment, Boolean alta) {
        this.idUser = idUser;
        this.publicacion = publicacion;
        this.comment = comment;
        this.alta = alta;
    }

    //Getter y Setter

    public String getIdComent() {
        return idComent;
    }

    public void setIdComent(String idComent) {
        this.idComent = idComent;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

}