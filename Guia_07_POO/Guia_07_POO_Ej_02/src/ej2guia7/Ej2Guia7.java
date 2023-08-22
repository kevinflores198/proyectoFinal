package ej2guia7;

import Entidad.Circunferencia;

public class Ej2Guia7 {

    public static void main(String[] args) {

        Circunferencia a = new Circunferencia();
        a.crearCircunferencia();
        a.area(a.getRadio());
        a.perimetro(a.getRadio());

    }

}
