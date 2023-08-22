package EJERCICIOS_GUIA6;

import java.util.Scanner;

public class ej21Guia6MIO {

    static Scanner hola = new Scanner(System.in);

    public static void main(String[] args) {

        /*--------------------------Definimos las matrices----------------------------*/
        int[][] grande = new int[10][10];

        int[][] chica = new int[3][3];

        System.out.println("Matriz principal de 10X10\n");

        /*------------------------Presentamos la matriz 10X10-------------------------*/
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grande[i][j] = (int) (Math.random() * 10);
            }
        }

        /*-------------------------Mostramos la matriz 10X10--------------------------*/
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print("[" + grande[i][j] + "]");
            }
            System.out.println("");
        }
        /*------------------Presentamos la matriz 3X3 por teclado---------------------*/

        System.out.println("\nIngrese la matriz a buscar de 3 x 3\n");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("[" + i + " , " + j + "]");
                chica[i][j] = hola.nextInt();
            }
        }

        /*--------------------------Llamamos la matriz 3X3----------------------------*/
        busqueda(grande, chica);

    }

    public static void busqueda(int[][] grande, int[][] chica) {

        boolean coincidenciaA = false;
        int fila = 0;
        int columna = 0;
        int coincidencia = 0;

        /*-----------------Definimos el que buscaremos la matriz 3X3------------------*/
        chau:

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                hola:

                if (grande[i][j] == chica[0][0]) {

                    for (int k = i; k < (i + 3); k++) {
                        for (int l = j; l < (j + 3); l++) {

                            if (grande[k][l] == chica[k - i][l - j]) {

                                coincidencia += 1;
                                if (coincidencia == 9) {
                                    fila = i;
                                    columna = j;
                                    coincidenciaA = true;
                                    break chau;
                                }
                            } else {
                                coincidencia = 0;
                                break hola;
                            }
                        }
                    }
                }
            }
        }

        /*------------------Encontramos y presentamos la matriz 3X3-------------------*/
        if (coincidenciaA) {
            System.out.println("La matriz grande contiene a la matriz chica\n\n");
            System.out.println("Se encuentra ubicada en: \n\n");
            for (int m = fila; m < (fila + 3); m++) {
                for (int n = columna; n < (columna + 3); n++) {
                    System.out.print("[" + m + " , " + n + "]");
                }
                System.out.println("");
            }
        } else {
            System.out.println("La matriz ingresada no se encuentra en la matriz grande");
        }
    }
}
