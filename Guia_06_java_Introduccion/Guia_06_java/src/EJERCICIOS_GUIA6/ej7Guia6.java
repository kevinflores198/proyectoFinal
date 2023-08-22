package EJERCICIOS_GUIA6;

import java.util.Scanner;

public class ej7Guia6 {
    
    /*Crear un programa que pida una frase y si esa frase 
    es igual a “eureka” el programa
    pondrá un mensaje de Correcto, sino mostrará 
    un mensaje de Incorrecto. Nota: investigar
    la función equals() en Java.*/

    public static void main(String[] args) {

        Scanner hola = new Scanner(System.in);

        String frase;

        System.out.print("Ingrese una frase: ");
        frase = hola.nextLine();

        if ("eureka".equals(frase)) {
            System.out.println("correcto");
        } else {
            System.out.println("incorrecto");
        }
    }
}
