package HerenciasEj4Segundo.entidades;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class estudiante extends persona {

    private String matricula;
    Scanner leer = new Scanner(System.in);

    private Map<String, Float> estudianteMapa = new HashMap<>();

    public Map<String, Float> getEstudianteMapa() {
        return estudianteMapa;
    }

    public void setEstudianteMapa(Map<String, Float> estudianteMapa) {
        this.estudianteMapa = estudianteMapa;
    }

    public estudiante() {
    }

    public estudiante(String matricula, String nombreCompleto, int dni, String estadoCivil) {
        super(nombreCompleto, dni, estadoCivil);
        this.matricula = matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return super.toString() + "\nMatricula: " + matricula;
    }

    public void estudianteCreado() {
        super.crearPersona();
        System.out.print("Ingrese la matricula: ");
        matricula = leer.next();
    }

    public void cambiarDatosEstudiante() {
        super.cambiarEstadoCivil();
        System.out.print("Ingrese la matricula que desea cambiar: ");
        matricula = leer.next();
    }
}
