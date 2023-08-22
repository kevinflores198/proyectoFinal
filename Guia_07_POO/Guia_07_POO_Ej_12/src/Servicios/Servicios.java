package Servicios;

import Persona.Persona;
import java.util.Date;
import java.util.Scanner;

public class Servicios {

    static Date nuevo = new Date(90, 10, 25);
    static Date actual = new Date();
    static int edadNueva = actual.getYear() - nuevo.getYear();
    static public Scanner leer = new Scanner(System.in);
   

    public Persona crearPersona() {

        Persona p = new Persona();

        System.out.println("Ingrese su nombre completo");
        String nombre = leer.nextLine();

        System.out.println("Ingrese fecha de nacimiento");

        System.out.print("Año:");
        int year = leer.nextInt() - 1900;
        System.out.print("Mes:");
        int mes = leer.nextInt() - 1;
        System.out.print("Dia:");
        int dia = leer.nextInt();

        Date nacimiendo = new Date(year, mes, dia);

        return new Persona(nombre, nacimiendo);
    }

    public double calcularEdad(Persona p) {

        double edad;

        edad = actual.getYear() - p.getFechaDeNacimiento().getYear();

        System.out.println("el usuario tiene " + edad + " aÃ±os");

        return edad;
    }

    public boolean menorQue(int edad) {
        boolean menor = false;

        System.out.println("La edad de una nueva persona ramdom es: " + nuevo);

        if (edad < edadNueva) {
            
            menor = true;
        }
        return menor;
    }

    public void mostrarPersona() {
        String nombrenuevo = "Kevin";
        System.out.println("El nombre de la persona es: " + nombrenuevo);
        System.out.println("Y la edad es: "+edadNueva);
    }
}
