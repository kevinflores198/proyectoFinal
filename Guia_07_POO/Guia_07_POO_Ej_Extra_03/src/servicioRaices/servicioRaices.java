package servicioRaices;

import Raices.Raices;
import java.util.Scanner;

public class servicioRaices {

    Raices r = new Raices();
    Scanner leer = new Scanner(System.in);

    public void valores(Raices r) {
        System.out.println("Ingrese los valores de a, b y c");
        r.setA(leer.nextInt());
        r.setB(leer.nextInt());
        r.setC(leer.nextInt());
    }

    public double getDiscriminante(Raices r) {

        double discriminante;
        discriminante = (Math.pow(r.getB(), 2)) - 4 * r.getA() * r.getC();
        return discriminante;
    }

    public boolean tieneRaices(Raices r) {
        boolean solu = false;
        if (getDiscriminante(r)>= 0) {
            solu=true;
        }
        return solu;

        //return (getDiscriminante(r) >= 0);
    }

    public boolean tieneRaiz(Raices r) {
        return (getDiscriminante(r) == 0);
    }

    public double[] obtenerRaices(Raices r) {
        double[] raices = new double[2];
        raices[0] = (-r.getB() + Math.sqrt(getDiscriminante(r))) / (2 * r.getA());
        raices[1] = (-r.getB() - Math.sqrt(getDiscriminante(r))) / (2 * r.getA());
        return raices;
    }

    public double obtenerRaiz(Raices r) {
        double raiz = -r.getB() / (2 * r.getA());
        return raiz;
    }

    public void calucar(Raices r) {
        if (tieneRaices(r)) {
            double[] raices = obtenerRaices(r);
            System.out.println("Las raices son " + String.format("%.3f", raices[0]) + " y " + String.format("%.3f", raices[1]));
        } else if (tieneRaiz(r)) {
            System.out.println("La raiz es: " + String.format("%.3f", obtenerRaiz(r)));
        } else if (getDiscriminante(r) < 0) {
            System.out.println("La ecuación no tiene solución real");
        }
    }
}
