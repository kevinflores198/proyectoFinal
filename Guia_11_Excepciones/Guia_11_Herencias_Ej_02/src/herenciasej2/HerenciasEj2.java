package herenciasej2;

import herenciasej2.Electrodomestico.Electrodomestico;
import herenciasej2.Lavadora.Lavadora;
import herenciasej2.Televisor.Televisor;
import java.util.ArrayList;
import java.util.Iterator;

public class HerenciasEj2 {

    public static void main(String[] args) {
        
        System.out.println("------------");
        System.out.println("Ejercicio 2");
        System.out.println("------------");

        Lavadora l = new Lavadora();
        l.crearLavadora();
        System.out.println("Precio de la lavadora: " + l.precioFinal());

        Televisor t = new Televisor();
        t.crearTelevisor();
        System.out.println("Precio final del televisor: " + t.precioFinal());

        System.out.println("\n------------");
        System.out.println("Ejercicio 3");
        System.out.println("------------");
        
        ArrayList<Electrodomestico> listaElectrodomesticos = new ArrayList();

        Televisor tele1 = new Televisor(20, true, 1000, "blanco", "a", 35);
        listaElectrodomesticos.add(tele1);
        Televisor tele2 = new Televisor(25, false, 1700, "azul", "d", 25);
        listaElectrodomesticos.add(tele2);

        Lavadora lava1 = new Lavadora(1500, "negro", "b", 45);
        listaElectrodomesticos.add(lava1);
        Lavadora lava2 = new Lavadora(3000, "rojo", "f", 65);
        listaElectrodomesticos.add(lava2);

        precioFinal(listaElectrodomesticos);
    }
    
    public static void precioFinal(ArrayList<Electrodomestico> listaElectrodomesticos) {

        Iterator<Electrodomestico> it = listaElectrodomesticos.iterator();

        float total = 0;
        float lavadora = 0;
        float televisor = 0;

        while (it.hasNext()) {

            Electrodomestico next = it.next();

            double precio = next.precioFinal();

            System.out.println("El precio final es de: " + precio);

            total += precio;

            if (next instanceof Lavadora) {
                lavadora += precio;
            } else {
                televisor += precio;
            }
        }

        System.out.println("Total de venta de televisores :" + televisor);
        System.out.println("Total de venta de lavadoras" + lavadora);
        System.out.println("Total de venta de electrodomesticos: " + total);
    }
}
