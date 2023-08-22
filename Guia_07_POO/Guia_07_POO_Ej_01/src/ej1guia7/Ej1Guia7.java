/*
Crear una clase llamada Libro que contenga los siguientes atributos: ISBN, Título, Autor,
Número de páginas, y un constructor con todos los atributos pasados por parámetro y un
constructor vacío. Crear un método para cargar un libro pidiendo los datos al usuario y
luego informar mediante otro método el número de ISBN, el título, el autor del libro y el numero de páginas.
 */
package Ej1Guia7;

import Libro.Libro1;
import java.util.Scanner;

public class Ej1Guia7 {

    static Scanner leer = new Scanner(System.in);

    /*---------------------------metodo inicial-----------------------------------*/
    public static void main(String[] args) {

        Libro1 L1 = new Libro1(), L2 = new Libro1(), L3 = new Libro1();

        carga(L1, L2, L3);

        muestra(L1, L2, L3);
    }

    /*-----------------metodo de carga de datos del libro-------------------------*/
    public static void carga(Libro1 L1, Libro1 L2, Libro1 L3) {

        int opcion;

        do {
            System.out.println("Ingrese el libro que desea cargar");
            System.out.println("1. Libro 1\n2. Libro 2\n3. Libro 3\n\nO ingrese 4 para salir\n");

            opcion = leer.nextInt();
            switch (opcion) {

                case 1:
                    System.out.println("Ingese el ISBN del libro N°1");
                    L1.setISBN(leer.nextInt());
                    leer.nextLine();
                    System.out.println("Ingese el titulo del libro N°1");
                    L1.settitulo(leer.nextLine());
                    System.out.println("Ingese el autor del libro N°1");
                    L1.setautor(leer.nextLine());
                    System.out.println("Ingese el cantidad de paginas del libro N°1");
                    L1.setpaginas(leer.nextInt());
                    break;
                case 2:
                    System.out.println("Ingese el ISBN del libro N°2");
                    L2.setISBN(leer.nextInt());
                    leer.nextLine();
                    System.out.println("Ingese el titulo del libro N°2");
                    L2.settitulo(leer.nextLine());
                    System.out.println("Ingese el autor del libro N°2");
                    L2.setautor(leer.nextLine());
                    System.out.println("Ingese el cantidad de paginas del libro N°2");
                    L2.setpaginas(leer.nextInt());
                    break;
                case 3:
                    System.out.println("Ingese el ISBN del libro N°3");
                    L3.setISBN(leer.nextInt());
                    leer.nextLine();
                    System.out.println("Ingese el titulo del libro N°3");
                    L3.settitulo(leer.nextLine());
                    System.out.println("Ingese el autor del libro N°3");
                    L3.setautor(leer.nextLine());
                    System.out.println("Ingese el cantidad de paginas del libro N°3");
                    L3.setpaginas(leer.nextInt());
                    break;
                case 4:
                    System.out.println("¡Adios!");
            }
        } while (opcion != 4);
    }

    /*-----------------------metodo para ver resultado----------------------------*/
    public static void muestra(Libro1 L1, Libro1 L2, Libro1 L3) {

        int opcion;

        do {

            System.out.println("¿Que libro quiere mostrar primero?: ");
            System.out.println("1. Libro 1\n2. Libro 2\n3. Libro 3\n\nO ingrese 4 para salir\n");

            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("ISBN: " + L1.getISBN());
                    System.out.println("titulo: " + L1.gettitulo());
                    System.out.println("autor: " + L1.getautor());
                    System.out.println("cantidad de paginas: " + L1.getpaginas());
                    break;
                case 2:
                    System.out.println("ISBN: " + L2.getISBN());
                    System.out.println("titulo: " + L2.gettitulo());
                    System.out.println("autor: " + L2.getautor());
                    System.out.println("cantidad de paginas: " + L2.getpaginas());
                case 3:
                    System.out.println("ISBN: " + L3.getISBN());
                    System.out.println("titulo: " + L3.gettitulo());
                    System.out.println("autor: " + L3.getautor());
                    System.out.println("cantidad de paginas: " + L3.getpaginas());
                case 4:
                    System.out.println("¡Adios!");
            }
        } while (opcion != 4);
    }
}
