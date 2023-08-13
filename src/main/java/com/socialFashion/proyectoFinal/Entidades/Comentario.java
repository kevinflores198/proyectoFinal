package com.socialFashion.proyectoFinal.Entidades;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
    private String idPublicacion;
    private String comment;
    private Boolean alta;
    private ArrayList<ReportComentario> reports;
    
    public Comentario() {
    }

    public Comentario(String idComent, String idUser, String idPublicacion, String comment, Boolean alta,
            ArrayList<ReportComentario> reports) {
        this.idComent = idComent;
        this.idUser = idUser;
        this.idPublicacion = idPublicacion;
        this.comment = comment;
        this.alta = alta;
        this.reports = reports;
    }

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

    public String getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(String idPublicacion) {
        this.idPublicacion = idPublicacion;
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

    public ArrayList<ReportComentario> getReports() {
        return reports;
    }

    public void setReports(ArrayList<ReportComentario> reports) {
        this.reports = reports;
    }

}