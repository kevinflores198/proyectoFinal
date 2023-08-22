package EJERCICIOS_GUIA6;

import java.util.Scanner;

public class ej6Guia6 {

    /*Crear un programa que dado un numero 
    determine si es par o impar.*/
    
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        System.out.println("Ingrese un numero");
        
        int num = leer.nextInt();

        if (num % 2 == 0) {
            System.out.println("El numero " + num + " es par");
        } else {
            System.out.println("El numero " + num + " es impar");
        }
    }
}
