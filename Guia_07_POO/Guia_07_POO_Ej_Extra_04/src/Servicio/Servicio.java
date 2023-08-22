package Servicio;

import java.util.Scanner;
import nif.nif;

public class Servicio {

    /*• Método crearNif(): le pide al usuario el DNI y con ese DNI calcula la letra que le
corresponderá. Una vez calculado, le asigna la letra que le corresponde según el
resultado del calculo.*/
    nif n = new nif();
    static Scanner leer = new Scanner(System.in);

    public void crearNif() {

        System.out.println("Ingrese su numero de DNI");
        n.setDni(leer.nextInt());
        
        
        
    }
}
