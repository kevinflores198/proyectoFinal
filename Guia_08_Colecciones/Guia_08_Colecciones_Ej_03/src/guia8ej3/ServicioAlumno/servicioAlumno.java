package guia8ej3.ServicioAlumno;

import guia8ej3.Alumno.Alumno;
import java.util.ArrayList;
import java.util.Scanner;

public class servicioAlumno {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    ArrayList<Alumno> alumnosLista = new ArrayList();

    public Alumno crearAlumnos() {

        Alumno a = new Alumno();
        System.out.println("Ingrese el nombre del alumno");
        a.setNombre(leer.next());
        
        for (int i = 0; i < 3; i++) {
            System.out.println("Ingrese la nota N° " + (i + 1));
            a.getNota().add(leer.nextInt());
        }
        return a;
    }

    public void crearListaDeAlumnos() {
        String respuesta;

        do {
            alumnosLista.add(crearAlumnos());
            System.out.println("Desea ingresar otor alumno? s/n");
            respuesta = leer.next();
        } while (respuesta.equals("s"));
    }

    public Double calcularNotaPorNOmbre() {
        int cont = 0;

        System.out.println("Ingrese el nombre de la persona que desea sacar el promedio");
        String nombre = leer.next();
        for (Alumno alumno : alumnosLista) {
            if (alumno.getNombre().equals(nombre)) {
                cont++;
                return (double) notaFinal(alumno.getNota());
            }
        }
        if (cont == 0) {
            System.out.println("No se encontro el alumno");
        }

        return null;
    }

    public float notaFinal(ArrayList<Integer> notas) {
        float notaFinal = 0;

        for (Integer nota : notas) {
            notaFinal += nota;
        }
        notaFinal = (notaFinal / 3);
        System.out.println("el primedio es: " + notaFinal);
        return notaFinal;
    }

    public void mostrarListaAlumnos() {
        for (Alumno alumno : alumnosLista) {
            System.out.println(alumno);
        }
    }

}
