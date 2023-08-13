package com.socialFashion.proyectoFinal.Entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Publicacion
 */
@Entity
public class Publicacion {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String idUser;
    private String label;
    private Imagen image;
    private String content;
    private LocalDate initialDate;

    @OneToMany
    private ArrayList<Comentario> comments;
    private Integer likes;

    private Boolean alta;

    public Publicacion() {
    }

    public Publicacion(String idUser, String label, Imagen image, String content, LocalDate initialDate,
            ArrayList<Comentario> comments, Integer likes, Boolean alta) {
        this.idUser = idUser;
        this.label = label;
        this.image = image;
        this.content = content;
        this.initialDate = initialDate;
        this.comments = comments;
        this.likes = likes;
        this.alta = alta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Imagen getImage() {
        return image;
    }

    public void setImage(Imagen image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(LocalDate initialDate) {
        this.initialDate = initialDate;
    }

    public ArrayList<Comentario> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comentario> comments) {
        this.comments = comments;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }
    
}