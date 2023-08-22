package HerenciasEj4Segundo.entidades;

import java.util.Scanner;

public class personalServicio extends empleado {

    private String asignacion;

    Scanner leer = new Scanner(System.in);
    
    public personalServicio() {
    }

    public personalServicio(String asignacion, int incorporacion, int despacho, String nombreCompleto, int dni, String estadoCivil) {
        super(incorporacion, despacho, nombreCompleto, dni, estadoCivil);
        this.asignacion = asignacion;
    }

    public String getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(String asignacion) {
        this.asignacion = asignacion;
    }

    @Override
    public String toString() {
        return super.toString() + "\nAsignacion: " + asignacion;
    }

    public void personalCreado() {
        super.crearPersona();
        super.incorporacionYDespacho();
        System.out.print("Ingrese su asignacion de trabajo: ");
        asignacion = leer.next();
        
    }

    public void cambiarDatosPersonal() {
        super.cambiarDatosEmpleado();
        System.out.print("Ingrese la nueva asignacion: ");
        asignacion = leer.next();
    }

}
