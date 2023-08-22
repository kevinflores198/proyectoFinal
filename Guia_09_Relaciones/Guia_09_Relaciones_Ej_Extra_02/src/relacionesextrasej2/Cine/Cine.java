package relacionesextrasej2.Cine;

import java.util.ArrayList;
import relacionesextrasej2.Pelicula.Pelicula;
import relacionesextrasej2.persona.Persona;

public class Cine {

    private Pelicula pelicula;
    private String[][] sala;
    private int precio;
    private ArrayList<Persona> personas;

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }

    public Cine() {
    }

    public Cine(Pelicula pelicula, String[][] sala, int precio, ArrayList<Persona> personas) {
        this.pelicula = pelicula;
        this.sala = sala;
        this.precio = precio;
        this.personas = personas;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public String[][] getSala() {
        return sala;
    }

    public void setSala(String[][] sala) {
        this.sala = sala;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void mostrarSala() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print("[" + this.sala[i][j] + "]");
            }
            System.out.println(" ");
        }
    }

}
