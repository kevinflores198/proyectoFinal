package com.socialFashion.proyectoFinal.Entidades;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;


import com.socialFashion.proyectoFinal.Enumeraciones.ReportsPublicacion;

/**
 * ReportPublicacion
 */
@Entity
public class ReportPublicacion {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idReport;

    @ManyToOne
    private Publicacion publicacion;

    private String idUser;
    private String reason;
    //private Boolean alta;

    @Enumerated(EnumType.STRING)
    private ReportsPublicacion typeReport;

    public ReportPublicacion() {
    }

    public ReportPublicacion(Publicacion publicacion, String idUser, String reason,
            ReportsPublicacion typeReport) {
        this.publicacion = publicacion;
        this.idUser = idUser;
        this.reason = reason;
        this.typeReport = typeReport;
    }

    //Getter y Setter

    public String getIdReport() {
        return idReport;
    }

    public void setIdReport(String idReport) {
        this.idReport = idReport;
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ReportsPublicacion getTypeReport() {
        return typeReport;
    }

    public void setTypeReport(ReportsPublicacion typeReport) {
        this.typeReport = typeReport;
    }
    
}