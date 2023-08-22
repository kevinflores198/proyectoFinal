package HerenciasEj4Segundo.entidades;

import java.util.Scanner;

public class profesor extends empleado {

    private String departamento;
    Scanner leer = new Scanner(System.in);

    public profesor() {
    }

    public profesor(String departamento, int incorporacion, int despacho, String nombreCompleto, int dni, String estadoCivil) {
        super(incorporacion, despacho, nombreCompleto, dni, estadoCivil);
        this.departamento = departamento;
    }
    
    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return super.toString() + "\nDepartamento: " + departamento;
    }

    public void profesorCreado() {
        super.crearPersona();
        super.incorporacionYDespacho();
        System.out.print("Ingrese su departamento: ");
        departamento = leer.next();
    }

    public void cambiarDatosProfesor() {
        super.cambiarDatosEmpleado();
        System.out.print("Ingrese su departamento: ");
        departamento = leer.next();
    }
}
