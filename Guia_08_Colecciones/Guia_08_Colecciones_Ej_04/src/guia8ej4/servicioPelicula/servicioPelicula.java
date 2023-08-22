/*
Un cine necesita implementar un sistema en el que se puedan cargar peliculas. Para esto,
tendremos una clase Pelicula con el título, director y duración de la película (en horas).
Implemente las clases y métodos necesarios para esta situación, teniendo en cuenta lo
que se pide a continuación:

 */
package guia8ej4.servicioPelicula;

import guia8ej4.comparador.Comparador;
import guia8ej4.pelicula.Pelicula;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class servicioPelicula {

    Scanner leer = new Scanner(System.in);
    ArrayList<Pelicula> arPeliculas = new ArrayList();

    public Pelicula creadorDePelicula() {
        //En el servicio deberemos tener un bucle que crea un objeto Pelicula pidiéndole al usuario
        //todos sus datos y guardándolos en el objeto Pelicula.
        Pelicula p = new Pelicula();

        System.out.println("Ingrese el titulo de la pelicula");
        p.setTitulo(leer.next());
        System.out.println("Ingrese el director de la pelicula");
        p.setDirector(leer.next());
        System.out.println("Ingrese la duracion de la pelicula");
        p.setDuracion(leer.nextDouble());
        return p;
    }

    public void listaPelicula() {
        //Después, esa Pelicula se guarda una lista de Peliculas y se le pregunta al usuario si quiere
        //crear otra Pelicula o no.

        String respuesta;

        do {
            arPeliculas.add(creadorDePelicula());
            System.out.println("Desea ingresar otra pelicula?");
            respuesta = leer.next();
        } while (respuesta.equals("s"));
    }

    public void mostrarTodasLasPeliculas() {
        //• Mostrar en pantalla todas las películas.

        System.out.println("\n-------------------Todas las peliculas--------------------");

        for (Pelicula arPelicula : arPeliculas) {
            System.out.println(arPelicula);
        }

    }

    public void mostrarPeliculasMayorAUnaHora() {
        //• Mostrar en pantalla todas las películas con una duración mayor a 1 hora.

        System.out.println("\n---------------------Duran una hora-----------------------");

        int contador = 0;
        Comparador c = new Comparador();

        for (Pelicula arPelicula : arPeliculas) {
            if (arPelicula.getDuracion() >= 1) {
                System.out.println(arPelicula);
                contador++;
            }
        }
        if (contador == 0) {
            System.out.println("No existe ninguna pelicula con mas de una hora de duracion");
        }

    }

    public void ordenarDuracionMayor() {
        //• Ordenar las películas de acuerdo a su duración (de mayor a menor) y mostrarlo en pantalla.

        System.out.println("\n---------------------Mayor a menor------------------------");

        Collections.sort(arPeliculas, Comparador.ordenarDuracionMayor);

        for (Pelicula arPelicula : arPeliculas) {
            System.out.println(arPelicula);
        }

    }

    public void ordenarDuracionMenor() {
        //• Ordenar las películas de acuerdo a su duración (de menor a mayor) y mostrarlo enpantalla.

        System.out.println("\n----------------------Menor a mayor-----------------------");

        Collections.sort(arPeliculas, Comparador.ordenarDuracionMenor);

        for (Pelicula arPelicula : arPeliculas) {
            System.out.println(arPelicula);
        }

    }

    public void ordenarTituloAlfabéticamente() {
        //• Ordenar las películas por título, alfabéticamente y mostrarlo en pantalla.

        System.out.println("\n-------------Titulo ordenado alfabeticamente--------------");

        Collections.sort(arPeliculas, Comparador.ordenarTituloAlfabéticamente);

        for (Pelicula arPelicula : arPeliculas) {
            System.out.println(arPelicula);
        }

    }

    public void ordenarDirectorAlfabéticamente() {
        //• Ordenar las películas por director, alfabéticamente y mostrarlo en pantalla.  

        System.out.println("\n----------Directores ordenados alfabeticamente------------");

        Collections.sort(arPeliculas, Comparador.ordenarDirectorAlfabéticamente);

        for (Pelicula arPelicula : arPeliculas) {
            System.out.println(arPelicula);
        }

    }

}
