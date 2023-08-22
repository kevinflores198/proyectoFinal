/*Realizar un programa en Java donde se creen dos arreglos:
el primero será un arreglo A
de 50 números reales, y el segundo B, un arreglo de 20 
números, también reales. 
///////////////////////////////////////////////////////////
El programa deberá inicializar el arreglo A con números 
aleatorios y mostrarlo por pantalla.
Luego, el arreglo A se debe ordenar de menor a mayor 
y copiar los primeros 10 números
ordenados al arreglo B de 20 elementos, y rellenar los
10 últimos elementos con el valor
0.5. Mostrar los dos arreglos resultantes: el ordenado
de 50 elementos y el combinado de
20.*/
package ej10guia7;

import Ej10Guia7.servicio.Servicios;
import java.util.Scanner;

public class Ej10Guia7 {

    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {

        Servicios s = new Servicios();

        s.llenarAyB();
    }

}
