package EJERCICIOS_GUIA6;

import java.util.Arrays;
import java.util.Scanner;

public class ej17Guia6 {

    static Scanner hola = new Scanner(System.in);

    public static void main(String[] args) {

        /*Recorrer un vector de N enteros contabilizando 
cuántos números son de 1 dígito, cuántos
de 2 dígitos, etcétera (hasta 5 dígitos).*/
        int n, largo, contador1 = 0, contador2 = 0, contador3 = 0, contador4 = 0, contador5 = 0, respuesta;

        System.out.println("ingrese la cantidad de numeros");
        n = hola.nextInt();

        String[] enteros;
        enteros = new String[n];

        for (int i = 0; i < n; i++) {
            do {
                System.out.println("ingrese un numero de hastra 5 digitos: ");
                enteros[i] = hola.next();
                largo = enteros[i].length();
                if (largo > 5) {
                    System.out.println("El numero es mayor a 5, ingrese el numero correcto");
                }
            } while (largo > 5);
            
        }

        for (int i = 0; i < n; i++) {
            do {
                System.out.println("seleccione que quiere ver:"
                        + "\n1. 1 cifra"
                        + "\n2. 2 cifras"
                        + "\n3. 3 cifras"
                        + "\n4. 4 cifras"
                        + "\n5. 5 cifras"
                        + "\n6. Ver todos"
                        + "\n7. salir");

                respuesta = hola.nextInt();

                switch (respuesta) {
                    case 1:
                        contador1++;
                        System.out.println("1 cifra ---> " + enteros[1].length());
                        break;
                    case 2:
                        contador2++;
                        System.out.println("2 cifras ---> " + enteros[2].length());
                        break;
                    case 3:
                        contador3++;
                        System.out.println("3 cifras ---> " + enteros[3].length());
                        break;
                    case 4:
                        contador4++;
                        System.out.println("4 cifras ---> " + enteros[4].length());
                        break;
                    case 5:
                        contador5++;
                        System.out.println("5 cifras ---> " + enteros[5].length());
                        break;

                    case 6:
                        System.out.println("Todo ---> " + enteros[i].length());
                        break;

                    case 7:

                        System.out.println("Salir");
                        System.out.println("Esta seguro? "
                                + "\n1. si"
                                + "\n2. no");
                        respuesta = hola.nextInt();

                        if (respuesta == 1) {
                            System.out.println("Gracias por usar nuestro sistema");
                        } else {
                            return;
                        }
                }
            } while (respuesta < 5);
        }
    }
}
