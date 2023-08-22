package Persona;

import java.util.Date;

public class Persona {

    private String nombre;
    private Date FechaDeNacimiento;

    public Persona() {
    }

    public Persona(String nombre, Date FechaDeNacimiento) {
        this.nombre = nombre;
        this.FechaDeNacimiento = FechaDeNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaDeNacimiento() {
        return FechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date FechaDeNacimiento) {
        this.FechaDeNacimiento = FechaDeNacimiento;
    }
}
