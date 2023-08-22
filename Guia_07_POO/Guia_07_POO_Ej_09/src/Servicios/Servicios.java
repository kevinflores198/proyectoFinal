package Servicios;

import Matematica.Matematica;

public class Servicios {

    public float devolverMayor(Matematica m) {

        if (m.getNum1() > m.getNum2()) {
            return m.getNum1();
        } else {
            return m.getNum2();
        }
    }

    public int calcularPotencia(Matematica m) {

        float mayor, menor;
        if (m.getNum1() == devolverMayor(m)) {
            mayor = m.getNum1();
            menor = m.getNum2();
        } else {
            mayor = m.getNum2();
            menor = m.getNum1();
        }

        return (int) Math.pow(Math.round(mayor), Math.round(menor));
    }

    public float calcularRaiz(Matematica r) {

        if (r.getNum1() == devolverMayor(r)) {
            return (float) Math.sqrt(Math.abs(r.getNum2()));
        }
        return (float) Math.sqrt(Math.abs(r.getNum1()));
    }
}
