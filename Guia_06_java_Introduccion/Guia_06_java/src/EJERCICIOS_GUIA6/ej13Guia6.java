package EJERCICIOS_GUIA6;

import java.util.Scanner;

public class ej13Guia6 {

    static Scanner hola = new Scanner(System.in);

    public static void main(String[] args) {

        /*
Dibujar un cuadrado de N elementos por lado 
utilizando el carácter “*”. Por ejemplo, si el
cuadrado tiene 4 elementos por lado se deberá dibujar lo siguiente:
* * * *
*     *
*     *
* * * *
         */
        int num1;

        System.out.println("Ingrese la cantidad de lados que desea tener para el cuadrado");

        num1 = hola.nextInt();

        //Linea SUPERIOR
        for (int i = 0; i < num1; i++) {

            System.out.print("*");

        }
        System.out.println("");

        //Centro
        for (int i = 0; i < num1 - 2; i++) {
            System.out.print("*");
            for (int j = 0; j < num1 - 2; j++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }

        //linea INFERIOR
        for (int i = 0; i < num1; i++) {
            System.out.print("*");
        }

        System.out.println("Rectangulo completo\n\n"
                + "Ingrese otro numero");

        int intento2 = hola.nextInt();

        for (int i = 0; i < intento2; i++) {
            for (int j = 0; j < intento2; j++) {
                System.out.print("*");
            }
            System.out.println("");

        }

    }

}
