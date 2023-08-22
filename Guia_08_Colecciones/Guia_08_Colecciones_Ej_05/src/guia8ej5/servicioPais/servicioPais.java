/*
Se requiere un programa que lea y guarde países, y para evitar que se ingresen repetidos
usaremos un conjunto. El programa pedirá un país en un bucle, se guardará el país en el
conjunto y después se le preguntará al usuario si quiere guardar otro país o si quiere salir,
si decide salir, se mostrará todos los países guardados en el conjunto. (Recordemos hacer
los servicios en la clase correspondiente)
Después deberemos mostrar el conjunto ordenado alfabéticamente: para esto recordar
cómo se ordena un conjunto.
Por último, al usuario se le pedirá un país y se recorrerá el conjunto con un Iterator, se
buscará el país en el conjunto y si está en el conjunto se eliminará el país que ingresó el
usuario y se mostrará el conjunto. Si el país no se encuentra en el conjunto se le informará
al usuario.
 */
package guia8ej5.servicioPais;

import guia8ej5.atributo.Pais;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class servicioPais {

    static Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public void cargarPaises(TreeSet<Pais> p) {

        do {
            Pais pa = new Pais();

            System.out.println("Ingrese un pais");
            pa.setNombre(leer.next());

            p.add(pa);

            System.out.println("desea ingresar otro pais? (s/n)");
        } while (leer.next().toLowerCase().equals("s"));
    }

    public void buscarPais(TreeSet<Pais> p) {

        String buscar;

        System.out.println("Ingrese un pais a eliminar");
        buscar = leer.next();

        Iterator<Pais> it = p.iterator();
        int cont = 0;

        while (it.hasNext()) {

            if (it.next().getNombre().equals(buscar)) {

                it.remove(); //lo usamos para eliminar lo que encontramos
                cont++;

                mostrarPaises(p);
            }
        }
        if (cont == 0) {

            System.out.println("\nEl pais ingresado no se encuentra en la lista");
            System.out.println("");
            mostrarPaises(p);
        }
    }

    public void mostrarPaises(TreeSet<Pais> p) {
        System.out.println("\nLista de los paises:");

        System.out.println("");
        for (Pais pais : p) {
            System.out.println(pais);
        }

    }
}
