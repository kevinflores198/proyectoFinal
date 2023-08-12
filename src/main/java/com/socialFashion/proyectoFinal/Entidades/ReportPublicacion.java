package com.socialFashion.proyectoFinal.Entidades;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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

    private String idPublicacion;
    private String idUser;
    private String reason;
    private boolean alta;

    @Enumerated(EnumType.STRING)
    private ReportsPublicacion typeReport;

    public ReportPublicacion() {
    }

    public ReportPublicacion(String idPublicacion, String idUser, String reason, boolean alta,
            ReportsPublicacion typeReport) {
        this.idPublicacion = idPublicacion;
        this.idUser = idUser;
        this.reason = reason;
        this.alta = alta;
        this.typeReport = typeReport;
    }

    public String getIdReport() {
        return idReport;
    }

    public void setIdReport(String idReport) {
        this.idReport = idReport;
    }

    public String getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(String idPublicacion) {
        this.idPublicacion = idPublicacion;
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

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

    public ReportsPublicacion getTypeReport() {
        return typeReport;
    }

    public void setTypeReport(ReportsPublicacion typeReport) {
        this.typeReport = typeReport;
    }

    
}