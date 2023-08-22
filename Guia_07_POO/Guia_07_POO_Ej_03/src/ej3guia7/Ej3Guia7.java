package ej3guia7;

import Calculos.Calculos;

public class Ej3Guia7 {

    public static void main(String[] args) {

        Calculos a = new Calculos();

        a.crearOperacion();

        System.out.println("La suma de los numeros es  " + a.suma());
        System.out.println("La resta de los numeros es  " + a.resta());
        if (a.multiplicacion() != 0) {
            System.out.println("La multiplicacion de los numeros es  " + a.multiplicacion());
        } else {
            System.out.println("ERROR");
        }
        if (a.division() != 0) {
            System.out.println("La division de los numeros es  " + a.division());
        } else {

            System.out.println("ERROR");
        }
    }
}
