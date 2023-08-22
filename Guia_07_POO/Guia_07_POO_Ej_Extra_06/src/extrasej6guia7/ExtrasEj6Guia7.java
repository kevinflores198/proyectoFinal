package extrasej6guia7;

import Ahorcado.Ahorcado;
import extrasej6guia7.Servicios.Servicio;
import java.util.Scanner;

public class ExtrasEj6Guia7 {

    public Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        Servicio s1 = new Servicio();
        Ahorcado p1 = s1.crearJuego();
        
        s1.longitud(p1);
        
        s1.juego(p1);
    }

}
