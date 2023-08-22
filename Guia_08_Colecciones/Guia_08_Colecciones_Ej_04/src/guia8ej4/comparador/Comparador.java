package guia8ej4.comparador;

import guia8ej4.pelicula.Pelicula;
import java.util.Comparator;

public class Comparador {

    public static Comparator<Pelicula> ordenarDuracionMayor = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula t, Pelicula t1) {

            return t1.getDuracion().compareTo(t.getDuracion());
        }
    };

    public static Comparator<Pelicula> ordenarDuracionMenor = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula t, Pelicula t1) {

            return t.getDuracion().compareTo(t1.getDuracion());
        }
    };

    public static Comparator<Pelicula> ordenarTituloAlfabéticamente = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula t, Pelicula t1) {

            return t.getTitulo().compareTo(t1.getTitulo());
        }
    };

    public static Comparator<Pelicula> ordenarDirectorAlfabéticamente = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula t, Pelicula t1) {

            return t.getDirector().compareTo(t1.getDirector());
        }
    };

}
