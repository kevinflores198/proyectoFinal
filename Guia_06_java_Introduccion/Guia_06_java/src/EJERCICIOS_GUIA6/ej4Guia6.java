package EJERCICIOS_GUIA6;

import java.util.Scanner;

public class ej4Guia6 {

    static Scanner leer = new Scanner(System.in);

        /*Dada una cantidad de grados centígrados 
        se debe mostrar su equivalente en grados
        Fahrenheit. La fórmula correspondiente 
        es: F = 32 + (9 * C / 5) .*/
    
    public static void main(String[] args) {

        int grados, far;

        System.out.println("Ingrese grados centigrados");

        grados = leer.nextInt();

        far = 32 + (9 * grados / 5);

        System.out.println("Usted ingresó " + grados + "°");
        System.out.println(" ");
        System.out.println("los cuales son " + far + "° fahrenheit");

    }
}
