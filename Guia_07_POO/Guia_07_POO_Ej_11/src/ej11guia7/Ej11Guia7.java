/*
11. Pongamos de lado un momento el concepto de POO, ahora 
vamos a trabajar solo con la
clase Date. En este ejercicio deberemos instanciar 
en el main, una fecha usando la clase
Date, para esto vamos a tener que crear 3 variables, 
dia, mes y anio que se le pedirán al
usuario para poner el constructor del objeto Date. 

Una vez creada la fecha de tipo Date,
deberemos mostrarla y mostrar cuantos años hay 
entre esa fecha y la fecha actual, que se
puede conseguir instanciando un objeto Date con 
constructor vacío.
Ejemplo fecha: Date fecha = new Date(anio, mes, dia);
Ejemplo fecha actual: Date fechaActual = new Date();
 */
package ej11guia7;

import java.util.Date;
import java.util.Scanner;

public class Ej11Guia7 {

    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Ingrese el año");
        int year = leer.nextInt() - 1900;

        System.out.println("Ingrese el mes");
        int mes = leer.nextInt() - 1;

        System.out.println("Ingrese el dia");
        int dia = leer.nextInt();

        Date fecha = new Date(year, mes, dia);

        System.out.println("Fecha: " + fecha);

        Date fechaActual = new Date();

        System.out.println("Fecha actual: " + fechaActual);

        if (fechaActual.getYear() != fecha.getYear()) {
            if (fechaActual.getYear() > fecha.getYear()) {
                int y = fechaActual.getYear() - fecha.getYear();
                System.out.println("La diferencia de años es: " + y + " años");
            }
        } else if (fechaActual.getYear() == fecha.getYear()) {
            System.out.println("El año ingresado es igual al año actual");
        }
    }

}
