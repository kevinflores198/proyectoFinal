package EJERCICIOS_GUIA6;

import java.util.Scanner;

public class ej10Guia6 {

    static Scanner read = new Scanner(System.in);

    /*Escriba un programa en el cual se ingrese un valor
    límite positivo, y a continuación solicite
    números al usuario hasta que la suma de los números
    introducidos supere el límite inicial. */
    
    public static void main(String[] args) {

        int limite = 0, num, cont = 0;

        System.out.println("Ingrese un numero limite a sumar: ");

        limite = read.nextInt();

        while (cont <= limite) {

            System.out.println("Ingrese un numero a sumar");

            num = read.nextInt();

            cont += num;
        }
        System.out.println("haz superado el limite");

    }
}
