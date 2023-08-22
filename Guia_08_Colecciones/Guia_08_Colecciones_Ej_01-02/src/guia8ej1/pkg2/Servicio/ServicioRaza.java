package guia8ej1.pkg2.Servicio;

import guia8ej1.pkg2.Raza.Raza;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ServicioRaza {

    Scanner leer = new Scanner(System.in);
    Raza r = new Raza();
    List<String> raza = new ArrayList();

    public void razas() {
        String respuesta = "s";
        String perro;
        System.out.println("--------------------");
        System.out.println("RAZAS DE PERRO");
        System.out.println("--------------------");
        while (respuesta.equals("s")) {

            System.out.println("Por favor ingrese la raza de perro pensada:");
            perro = leer.next();

            raza.add(perro);

            System.out.println("¿Quiere guardar otro perro? s/n");
            respuesta = leer.next();
        }
    }

    public void mostrar() {
        System.out.println("--------------------");
        System.out.println("MOSTRAR RAZAS");
        System.out.println("--------------------");
        System.out.println("Las razas de perros ingresadas son: ");

        for (String aux : raza) {
            System.out.println(aux);
        }
        System.out.println("Cantidad de razas: " + raza.size());

    }

    public void buscarYEliminar() {
        String buscar;
        int contador = 0;
        System.out.println("--------------------");
        System.out.println("BUSCAR RAZAS");
        System.out.println("--------------------");
        System.out.println("Que raza desea buscar?");

        buscar = leer.next();

        Iterator<String> it = raza.iterator();

        while (it.hasNext()) {
            String aux = it.next();

            System.out.println("La raza encontrada es: " + aux);
            System.out.println(" ");

            if (aux.equals(buscar)) {
                System.out.println("Eliminamos la raza ingresada.");
                it.remove();
                contador++;
                break;
            }
        }
        if (contador == 1) {
            Collections.sort(raza);
            System.out.println("la lista actualizada es:");

            for (String str : raza) {

                System.out.println(str);
            }
        }
    }
}
