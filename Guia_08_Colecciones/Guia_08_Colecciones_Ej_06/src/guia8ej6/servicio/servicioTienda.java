package guia8ej6.servicio;

import guia8ej6.tienda.Tienda;
import java.util.Map;
import java.util.Scanner;

public class servicioTienda {

    static Scanner leer = new Scanner(System.in).useDelimiter("\n");
    static Tienda t = new Tienda();

    public Tienda ingresarProducto() {
        String producto;
        do {
            System.out.println("Ingresar por favor el nombre del producto");
            producto = leer.next();
            System.out.println("Ingrese el precio");
            t.getP().put(producto, leer.nextFloat());
            System.out.println("Desea seguir ingresando productos? (s/n)");
        } while (leer.next().toLowerCase().equals("s"));

        return t;
    }

    public void modificarPrecio() {
        do {
            System.out.println("Ingrese el producto al cual desea modificar el precio");
            t.getP().replace(leer.next(), leer.nextFloat());
            System.out.println("Desea modificar algun precio mas? (s/n)");
        } while (leer.next().toLowerCase().equals("s"));
    }

    public void eliminarProducto() {
        do {
            System.out.println("Que producto desea eliminar?");
            t.getP().remove(leer.next(), leer.nextFloat());
            
            System.out.println("Desea eliminar otro producto? (s/n)");

        } while (leer.next().toLowerCase().equals("s"));
    }

    public void mostrarProducto() {

        for (Map.Entry<String, Float> mp : t.getP().entrySet()) {
            String key = mp.getKey();
            Float value = mp.getValue();
            System.out.println("\nEl producto es: " + key + "\nEl precio es: $" + value + "\n");
        }

    }

}
