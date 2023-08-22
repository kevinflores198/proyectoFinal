package ej8guia7;

import Cadena.Cadena;
import Servicio.Servicio;
import java.util.Scanner;

public class Ej8Guia7 {

    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        
        Cadena a = new Cadena();
        Servicio s = new Servicio();
        
        String Letra, f;
        System.out.println("Ingrese una frase");
        a.setFrase(leer.nextLine());
        a.setLargoCadena(a.getFrase().length());
        System.out.println("La cantidad de vocales es : ");
        System.out.println(s.mostrarVocales(a));
        System.out.println("Frase invertida");
        System.out.println(s.invertirFrase(a));
        System.out.println("Ingrese una letra a buscar que se repite en la frase");
        Letra = leer.nextLine();
        System.out.println("El caracter se repite: ");
        System.out.println(s.vecesRepetido(a, Letra) + " veces");
        System.out.println("Ingrese una nueva frase para comparar la longitud: ");
        f = leer.nextLine();
        System.out.println("La diferencia entre las cadenas es: ");
        System.out.println(s.compararLongitud(a.getLargoCadena(), f));
        System.out.println("Ingrese una frase a concatenar: ");
        f = leer.nextLine();
        System.out.println("La frase \"" + f + "\" queda :  \"" + s.unirFrases(f, a) + "\" junto a la frase inicial");
        System.out.println("Ingrese una letra para cambiar por las A de la frase original:");
        Letra = leer.nextLine();
        System.out.println("La frase con las A cambiadas es: ");
        System.out.println(s.reemplazar(a, Letra));
        System.out.println("Ingrese una letra para buscar en la frase");
        Letra = leer.next();
        if (s.contiene(a, Letra)) {
            System.out.println("La frase si contiene ese caracter");
        } else {
            System.out.println("La frase no contiene ese caracter");
        }
    }
}
