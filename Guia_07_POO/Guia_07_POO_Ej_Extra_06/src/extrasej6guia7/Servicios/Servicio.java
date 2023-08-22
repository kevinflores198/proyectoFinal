package extrasej6guia7.Servicios;

import Ahorcado.Ahorcado;
import java.util.Scanner;

public class Servicio {

    public Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public Ahorcado crearJuego() {

        Ahorcado a = new Ahorcado();
        
        System.out.println("AHORCADO:\n");

        System.out.println("Ingrese la cantidad de intentos maximos a tener:\n");
        a.setJugadasMaxima(leer.nextInt());

        System.out.println("Ingrese la palabra:\n");
        a.setLetra(leer.next());

        char[] caracteres = new char[a.getLetra().length()];

        for (int i = 0; i < a.getLetra().length(); i++) {
            caracteres[i] = a.getLetra().charAt(i);
        }
        a.setBuscar(caracteres);
        return a;
    }

    public void longitud(Ahorcado a) {

        for (int i = 0; i < a.getBuscar().length; i++) {

            System.out.print(" _");
        }
        System.out.println("");

        System.out.println("La longitud de la palabra es: " + a.getBuscar().length);

    }

    public int buscar(Ahorcado a) {

        char letra;
        int encontrado = 0;

        System.out.println("Ingrese la letra a buscar en la palabra: ");
        letra = leer.next().charAt(0);

        for (int i = 0; i < a.getBuscar().length; i++) {
            if (a.getBuscar()[i] == letra) {
                encontrado++;
            }
        }
        if (encontrado == 1) {
            System.out.println("La letra esta dentro de la palabra y se encontro " + encontrado + " vez\n");

        } else {
            System.out.println("La letra esta dentro de la palabra y se encontro " + encontrado + " veces\n");

        }
        a.setLetraAcertada(a.getLetraAcertada() + encontrado);
        return encontrado;
    }

    public boolean encontradas(Ahorcado a) {

        if (buscar(a) == 0) {
            a.setJugadasMaxima(a.getJugadasMaxima() - 1);

            if (a.getJugadasMaxima() == 1) {
                System.out.println("Le queda " + a.getJugadasMaxima() + " intento\n");

            } else {
                System.out.println("Le quedan " + a.getJugadasMaxima() + " intentos\n");
            }

            return false;
        }

        return true;

    }

    public void juego(Ahorcado a) {
        boolean resultado = false;

        do {
            encontradas(a);
            if (a.getBuscar().length == a.getLetraAcertada()) {
                resultado = true;
                break;
            }
        } while (a.getJugadasMaxima() != 0);
        if (resultado) {
            System.out.println("¡¡Felicidades!! Gano el juego"
                    + " \n\n La palabra a buscar era " + a.getLetra());
        } else {
            System.out.println("Lo sentimos, ha perdido el juego."
                    + " \n\nLa palabra a buscar era " + a.getLetra());

        }

    }
}
