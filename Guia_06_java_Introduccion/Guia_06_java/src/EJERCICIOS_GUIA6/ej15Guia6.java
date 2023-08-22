package EJERCICIOS_GUIA6;

public class ej15Guia6 {

    /*Realizar un algoritmo que rellene un vector 
    con los 100 primeros números enteros y los
muestre por pantalla en orden descendente.*/
    public static void main(String[] args) {

        int[] vec = new int[100];
        for (int i = 0; i < 100; i++) {
            vec[i] = i + 1;
        }
        for (int i = 99; i >= 0; i--) {
            System.out.println(vec[i]);
        }
    }
}
