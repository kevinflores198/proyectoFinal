package EJERCICIOS_GUIA6;

import java.util.Scanner;

public class ej14Guia6 {

    static Scanner hola = new Scanner(System.in);

    public static void main(String[] args) {

        /*
Crea una aplicación que a través de una 
función nos convierta una cantidad de euros
introducida por teclado a otra moneda, estas 
pueden ser a dólares, yenes o libras. La
función tendrá como parámetros, la cantidad de
euros y la moneda a converir que será
una cadena, este no devolverá ningún valor y 
mostrará un mensaje indicando el cambio
(void).
El cambio de divisas es:
 * 0.86 libras es un 1 €
 * 1.28611 $ es un 1 €
 * 129.852 yenes es un 1 €*/
        double euros, libras, yenes, dolares;
        int opcion;

        libras = 0.86;
        dolares = 1.28611;
        yenes = 129.852;
        System.out.println("ingrese la cantidad de euros");

        euros = hola.nextDouble();

        System.out.println("Ahora ingrese que clase de moneda le gustaria cambiar esos euros");
        System.out.println(" ");
        System.out.println("1. dolares\n2. yenes\n3. libras\nSi no desea hacer calculos, seleccione 4.");
        opcion = hola.nextInt();
        do {
            switch (opcion) {
                case 1:
                    System.out.println("La cantidad de euros pasados a dolares es de: " + (dolares * euros));
                    break;
                case 2:
                    System.out.println("La cantidad de euros pasados a yenes es de: " + (yenes * euros));
                    break;
                case 3:
                    System.out.println("La cantidad de euros pasados a libras es de: " + (libras * euros));
                    break;

            }
        } while (opcion < 0 && opcion > 4);
        System.out.println("Gracias por usar nuestro programa");
    }
}
