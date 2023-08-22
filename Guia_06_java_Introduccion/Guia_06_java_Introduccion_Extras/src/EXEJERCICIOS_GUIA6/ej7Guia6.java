/*
Realice un programa que calcule y 
visualice el valor máximo, el valor mínimo y el promedio
de n números (n>0). El valor de n se solicitará
al principio del programa y los números
serán introducidos por el usuario. Realice dos 
versiones del programa, una usando el
bucle “while” y otra con el bucle “do - while”.
 */
package EXEJERCICIOS_GUIA6;

import java.util.Scanner;

public class ej7Guia6 {

    static Scanner hola = new Scanner(System.in);

    public static void main(String[] args) {

        int num = 0, maximo = 0, minimo = 0, suma = 0;

        System.out.println("------------Primera manera------------");

        System.out.println("Ingrese un numero, ingrese un 0 para terminar");

        num = hola.nextInt();
        minimo = num;
        while (num != 0) {

            if (num > maximo) {
                maximo = num;
            } else if (num < minimo) {
                minimo = num;
            }
            suma += num;
            System.out.println("Ingrese otro numero");
            num = hola.nextInt();
        }

        System.out.println("Haz ingresado 0, se termino el programa");
        System.out.println("El numero MAXIMO es: " + maximo);
        System.out.println("El numero MINIMO es: " + minimo);
        System.out.println("El promedio es: " + suma);

        System.out.println("------------Segunda manera------------");

        System.out.println("Ingrese un numero");

        num = hola.nextInt();

        do {
            if (num > maximo) {
                maximo = num;
            } else if (num < minimo) {
                minimo = num;
            }
            suma += num;
            System.out.println("Ingrese otro numero");
            num = hola.nextInt();
        } while (num != 0);

        System.out.println("Haz ingresado 0, se termino el programa");
        System.out.println("El numero MAXIMO es: " + maximo);
        System.out.println("El numero MINIMO es: " + minimo);
        System.out.println("El promedio es: " + suma);

    }

}
