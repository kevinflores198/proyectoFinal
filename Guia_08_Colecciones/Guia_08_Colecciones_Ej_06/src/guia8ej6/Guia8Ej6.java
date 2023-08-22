package guia8ej6;

import guia8ej6.servicio.servicioTienda;
import guia8ej6.tienda.Tienda;
import java.util.Scanner;

public class Guia8Ej6 {

    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {

        Tienda t = new Tienda();
        servicioTienda st = new servicioTienda();

        int respuesta;

        do {
            System.out.println("Que desea hacer?");
            System.out.println("1. introducir un producto\n"
                    + "2. Modificar su precio\n"
                    + "3. Eliminar un producto\n"
                    + "4. Mostrar los productos\n"
                    + "5. Salir");
            respuesta = leer.nextInt();
            switch (respuesta) {
                case 1:
                    st.ingresarProducto();
                    break;
                case 2:
                    st.modificarPrecio();
                    break;
                case 3:
                    st.eliminarProducto();
                    break;
                case 4:
                    st.mostrarProducto();
            }
        } while (respuesta <= 4);
        System.out.println("Gracias por usar nuestro servicio");
    }
}
