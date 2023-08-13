
package com.socialFashion.proyectoFinal.Entidades;

import com.socialFashion.proyectoFinal.Enumeraciones.ReportsUser;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity

public class ReportUser {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idReporte;
    
    @ManyToOne
    private Usuario user;

    private String idUserReported;
    private String reason;
    //private Boolean alta;     Por si hace falta
    
    @Enumerated(EnumType.STRING)
    private ReportsUser typeReport;

    public ReportUser() {
    }

    public ReportUser(Usuario user, String idUserReported, String reason, ReportsUser typeReport) {
        this.user = user;
        this.idUserReported = idUserReported;
        this.reason = reason;
        this.typeReport = typeReport;
    }

    //Getter y Setter

    public String getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(String idReporte) {
        this.idReporte = idReporte;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public String getIdUserReported() {
        return idUserReported;
    }

    public void setIdUserReported(String idUserReported) {
        this.idUserReported = idUserReported;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    // public Boolean getAlta() {
    //     return alta;
    // }

    // public void setAlta(Boolean alta) {
    //     this.alta = alta;
    // }

    public ReportsUser getTypeReport() {
        return typeReport;
    }

    public void setTypeReport(ReportsUser typeReport) {
        this.typeReport = typeReport;
    }
       
}
