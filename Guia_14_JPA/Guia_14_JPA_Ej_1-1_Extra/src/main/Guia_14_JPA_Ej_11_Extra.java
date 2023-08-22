package main;

import entidades.Autor;
import entidades.Editorial;
import entidades.Libro;
import java.util.Scanner;
import servicio.autorServicio;
import servicio.editorialServicio;
import servicio.libroServicio;

public class Guia_14_JPA_Ej_11_Extra {

    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        libroServicio ls = new libroServicio();
        Autor autor = new Autor();
        Libro libro = new Libro();
        Editorial editorial = new Editorial();
        libroServicio libroServicio = new libroServicio();
        autorServicio autorServicio = new autorServicio();
        editorialServicio editorialServicio = new editorialServicio();
        int menu;
        Long isbn=0l;
        
        do {
            System.out.println("\nQue desea ver?\n"
                    + "\n1. Libros"
                    + "\n2. Autores"
                    + "\n3. Editoriales"
                    + "\n4. Salir ");
            menu = leer.nextInt();
            switch (menu) {
                case 1:
                    libroServicio.menuLibro(libro);
                    break;
                case 2:
                    
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Nos vemos!");
                    break;
            }
        } while (menu != 4);
    }

}
