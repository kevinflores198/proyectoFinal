package guia8ej3;

import guia8ej3.ServicioAlumno.servicioAlumno;
import java.util.Scanner;

public class Guia8Ej3 {

    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {

        servicioAlumno sa = new servicioAlumno();

        sa.crearListaDeAlumnos();
        sa.mostrarListaAlumnos();
        do {
            sa.calcularNotaPorNOmbre();
            System.out.println("Desea buscar otro alumno");

        } while (leer.next().equals("s"));
    }

}
