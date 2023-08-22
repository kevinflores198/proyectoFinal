package ServicioCancion.java;

import Cancion.Cancion;
import java.util.Scanner;

public class ServicioCancion {

    Cancion a = new Cancion();
    Scanner leer = new Scanner(System.in);

    public void Palabra() {
        System.out.println("Ingrese el nombre de la cancion:");
        a.setTitulo(leer.nextLine());
        System.out.println("Ingrese el nombre del autor: ");
        a.setCancion(leer.nextLine());
        System.out.println("El titulo es: " + a.getCancion());
        System.out.println("Y el titulo es: " + a.getCancion());
    }
}
