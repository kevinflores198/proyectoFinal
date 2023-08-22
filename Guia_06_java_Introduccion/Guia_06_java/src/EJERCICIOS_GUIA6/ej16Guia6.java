package EJERCICIOS_GUIA6;

import java.util.Scanner;

public class ej16Guia6 {

    public static void main(String[] args) {

        /*Realizar un algoritmo que rellene un vector 
de tamaño N con valores aleatorios / y le pida al
usuario un numero a buscar en el vector. / 
El programa mostrará donde se encuentra el
numero y si se encuentra repetido*/
        Scanner leer = new Scanner(System.in);

        int vec, buscar, cont = 0;

        System.out.println("Ingrese tamaño del vector");

        vec = leer.nextInt();

        int aleatorio[] = new int[vec];

        System.out.println("Ingrese numero a buscar");

        buscar = leer.nextInt();

        for (int i = 0; i < vec; i++) {

            aleatorio[i] = (int) (Math.random() * 10);

        }

        for (int i = 0; i < vec; i++) {
            if (buscar == aleatorio[i]) {
                cont++;
                System.out.println("El numero " + buscar + " se encontró en la posicion " + i);
            }
        }
        System.out.println("El numero " + buscar + " se encontró " + cont + " veces");

    }

}
