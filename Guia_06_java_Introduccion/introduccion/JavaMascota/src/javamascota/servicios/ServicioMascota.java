package javamascota.servicios;

import java.util.ArrayList;
import java.util.Scanner;
import javamascota.encontrar.Mascota;

public class ServicioMascota {

    private Scanner leer;
    private ArrayList<Mascota> mascotas;

    public ServicioMascota() {
        this.mascotas = new ArrayList();
        this.leer = new Scanner(System.in).useDelimiter("\n");

    }

    public Mascota crearMascota() {

        System.out.println("introducir nombre");
        String nombre = leer.next();

        System.out.println("introducir apodo");
        String apodo = leer.next();

        System.out.println("introducir tipo");
        String tipo = leer.next();

        return new Mascota(nombre,apodo,tipo);
    }

    public void agregarMascota(Mascota m) {
        mascotas.add(m);
    }

    public void mostrarMascotas() {
        System.out.println("\nLas mascotas actuales de la lista mascotas son:");

        for (Mascota aux : mascotas) {
            System.out.println(aux.toString());
        }
        System.out.println("\nCantidad:" + mascotas.size());
    }

    /**
     *
     * @param cantidad equivale a la cantidad de mascotas a crear y añadir.
     */
    public void fabricaChiquitos(int cantidad) {

        for (int i = 0; i < cantidad; i++) {
            mascotas.add(new Mascota("kev", "chiquito", "chiqui")); //forma mas efectiva de hacerlo

        }
    }

    /**
     * crear las mascotas por teclado
     *
     * @param cantidad
     */
    public void fabricaMascota(int cantidad) {

        for (int i = 0; i < cantidad; i++) {
            Mascota mascotaCreada = crearMascota();
            
            agregarMascota(mascotaCreada);

            System.out.println(mascotaCreada.toString());
        }
    }

    public void actualizarMascota(int index) {

        if (index <= (mascotas.size() - 1)) {
            System.out.println("");
            System.out.println("\n------------Actualizar------------");
            Mascota m = crearMascota();

            mascotas.set(index, m);
        } else {
            System.out.println("\nFallo al actualizarEl indice es erroneo");
        }
    }

    public void eliminarMascota(int index) {
        System.out.println("");
        System.out.println("\n------------Eliminar------------");
        if (index <= (mascotas.size() - 1)) {
            mascotas.remove(index);

        } else {
            System.out.println("\nFallo al eliminar, El indice es erroneo");
        }
    }
}
//ir a la pagina de oracle