package ej13guia7.Servicio;

import ej13guia7.Curso.Curso;
import java.util.Scanner;

public class Servicio {
Scanner leer = new Scanner(System.in);

    /*
     método cargarAlumnos(): este método le permitirá al usuario ingresar los alumnos
que asisten a las clases. Nosotros nos encargaremos de almacenar esta información
en un arreglo e iterar con un bucle, solicitando en cada repetición que se ingrese el
nombre de cada alumno.
     */
    public void cargarAlumnos() {
        
        Curso c = new Curso();

        for (int i = 1; i < 6; i++) {
            System.out.println("Ingrese el alumno N°"+i);
            c.getAlumnos()[i] = leer.next();
        }
        for (int i = 1; i < 6; i++) {
            System.out.println(i);
        }
    }
}
