package EJERCICIOS_GUIA6;

import java.util.Scanner;

public class ej11Guia6 {

    public static void main(String[] args) {

/*Realizar un programa que pida dos números enteros 
positivos por teclado y muestre por
pantalla el siguiente menú:
        
MENU
1. Sumar
2. Restar
3. Multiplicar
4. Dividir
5. Salir
        
Elija opción:
El usuario deberá elegir una opción y el programa deberá 
mostrar el resultado por pantalla
y luego volver al menú. El programa deberá ejecutarse 
hasta que se elija la opción 5.
Tener en cuenta que, si el usuario selecciona la opción
5, en vez de salir del programa
directamente, se debe mostrar el siguiente mensaje de 
confirmación: ¿Está seguro que
desea salir del programa (S/N)? Si el usuario selecciona
el carácter ‘S’ se sale del
programa, caso contrario se vuelve a mostrar el menú.*/

        Scanner read = new Scanner(System.in);
        int Opcion, Num1, Num2, decision;

        System.out.print("Ingrese un numero para operar: ");
        Num1 = read.nextInt();
        System.out.print("Ingrese otro numero para operar: ");
        Num2 = read.nextInt();
        do {
            System.out.println("-----------------------------");
            System.out.println("1. Sumar\n2.Restar\n3.Multiplicar\n4.Dividir\n5.Salir");
            System.out.println("-----------------------------");

            System.out.print("Ingrese un numero de zona a la que quiera dirigirse: ");

            Opcion = read.nextInt();

            switch (Opcion) {
                case 1:
                    System.out.println("El resultado de " + Num1 + " + " + Num2 + " es: " + (Num1 + Num2));
                    break;
                case 2:
                    System.out.println("El resultado de " + Num1 + " - " + Num2 + " es: " + (Num1 - Num2));
                    break;
                case 3:
                    System.out.println("El resultado de " + Num1 + " * " + Num2 + " es: " + (Num1 * Num2));
                    break;
                case 4:
                    System.out.println("El resultado de " + Num1 + " / " + Num2 + " es: " + (Num1 / Num2));
                    break;
                case 5:
                    Opcion = Salir();
                    break;
            }
        } while (Opcion != 5);
        System.out.println("Gracias por usar nuestro programa!");
    }

    public static int Salir() {
        Scanner readln = new Scanner(System.in);
        int Decision;

        System.out.print("Ingrese:\n1.Salir\n2.Volver al menu\n-->");
        Decision = readln.nextInt();
        if (Decision == 1) {
            return 5;
        } else {
            return 0;
        }

    }

}
