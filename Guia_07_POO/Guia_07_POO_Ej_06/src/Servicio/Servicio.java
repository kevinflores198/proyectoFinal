package Servicio;

import Cafe.Nespresso;
import java.util.Scanner;

public class Servicio {

    Nespresso n = new Nespresso();
    Scanner leer = new Scanner(System.in);

    /*• Método llenarCafetera(): hace que la cantidad actual sea igual a la capacidad máxima.*/
    public double llenarCafetera(Nespresso n) {

        System.out.println("Ingrese la capacidad maxima de cafe en mililitros");
        n.setCapacidadMaxima(leer.nextInt());

        System.out.println("La cantidad actual de cafe en mililitros es: " + n.getCapacidadMaxima());

        return n.getCapacidadMaxima();
    }

    /*• Método servirTaza(int): 
    
    se pide el tamaño de una taza vacía
    
    el método recibe el tamaño de la taza y simula la acción de servir la taza con la 
    capacidad indicada. 
    
    Si la cantidad actual de café “no alcanza” para llenar la taza, se sirve lo que quede. 
    El método le informará al usuario si se llenó o no la taza, y de no haberse llenado en
    cuanto quedó la taza.*/
    /**
     *
     * @param n
     * @return
     */
    public int servirTaza(Nespresso n) {

        int tazaVacia, resto, llenarCafe;

        System.out.println("Ingrese el tamaño de la taza en mililitros ");
        tazaVacia = leer.nextInt();

        System.out.println("Ingrese cuanto cafe desea llenar: ");
        llenarCafe = leer.nextInt();

        resto = (int) n.getCapacidadMaxima() - llenarCafe;

        if (llenarCafe <= resto) {

            System.out.println("La cantidad acutal de cafe es " + resto);

        } else if (llenarCafe > resto) {

            System.out.println("no tiene la capacidad suficiente en mililitros para llenar su taza");
            System.out.println("lo que puede sacar en mililitros es " + resto);
        }
        return resto;
    }

    /*• Método vaciarCafetera(): pone la cantidad de café actual en cero.*/
    public int vaciarCafetera(Nespresso n) {
        int vaciar = servirTaza(n);
        vaciar = vaciar - vaciar;
        System.out.println("La cafetera se ha limpiado y ha quedado en: " + vaciar);
        return vaciar;
    }

    /*• Método agregarCafe(int): se le pide al usuario una cantidad de café, el método lo
recibe y se añade a la cafetera la cantidad de café indicada.*/
    /**
     *
     * @param n
     * @return
     */
    public int agregarCafe(Nespresso n) {

        int cafeteraVacia = vaciarCafetera(n);
        int aniadir, total;

        do {
            System.out.println("Ingrese cuanto cafe quiere ingresar:");
            aniadir = leer.nextInt();
            total = cafeteraVacia + aniadir;
            System.out.println("La cafetera que estaba en " + cafeteraVacia + " ahora esta con " + aniadir + " mililitros");
            if (total <= aniadir) {
                System.out.println("se esta superando la capacidad maxima, esta es: " + total);
            }
        } while (cafeteraVacia != aniadir);

        System.out.println("La cafetera posee" + total + "cafe");
        return total;
    }
}
