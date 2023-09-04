package com.socialFashion.proyectoFinal.Entidades;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
// import org.springframework.format.annotation.DateTimeFormat;
// import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.socialFashion.proyectoFinal.Enumeraciones.Role;

/**
 *  Entidad Usuario
 */

@Entity
public class Usuario {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Enumerated(EnumType.STRING)
    private Role role;
    
    private String name;
    private String email;
    private String password;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @OneToOne
    private Imagen image;
    
    private Boolean alta;

    @OneToMany
    private ArrayList<Publicacion> publicacion;
    
    private ArrayList<ReportUser> report;

    public Usuario() {
    }

    public Usuario(Role role, String name, String email, String password, Date birthDate, Imagen image,
            Boolean alta) {
        this.role = role;
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
        this.image = image;
        this.alta = alta;
    }

    //Getter y Setter

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Imagen getImage() {
        return image;
    }

    public void setImage(Imagen image) {
        this.image = image;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }
    
}
