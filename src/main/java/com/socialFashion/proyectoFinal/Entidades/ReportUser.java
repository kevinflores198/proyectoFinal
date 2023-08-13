
package com.socialFashion.proyectoFinal.Entidades;

import com.socialFashion.proyectoFinal.Enumeraciones.ReportsUser;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity

public class ReportUser {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idReporte;
    
    private String idUser;
    private String idUserReported;
    private String reason;
    private Boolean alta;
    
    @Enumerated(EnumType.STRING)
    private ReportsUser typeReport;

    public ReportUser() {
    }

    public ReportUser(String idReporte, String idUser, String idUserReported, String reason, Boolean alta, ReportsUser typeReport) {
        this.idReporte = idReporte;
        this.idUser = idUser;
        this.idUserReported = idUserReported;
        this.reason = reason;
        this.alta = alta;
        this.typeReport = typeReport;
    }

    public String getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(String idReporte) {
        this.idReporte = idReporte;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
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

    public Boolean isAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

    public ReportsUser getTypeReport() {
        return typeReport;
    }

    public void setTypeReport(ReportsUser typeReport) {
        this.typeReport = typeReport;
    }
    
    
    
    
    
}
