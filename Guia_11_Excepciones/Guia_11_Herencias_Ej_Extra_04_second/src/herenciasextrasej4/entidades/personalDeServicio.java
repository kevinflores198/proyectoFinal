/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herenciasextrasej4.entidades;

/**
 * • Sobre el personal de servicio, hay que conocer a qué sección están
 * asignados (biblioteca, decanato, secretaría, ...).
 */
public class personalDeServicio extends empleado {

    private String seccionAsignada;

    public personalDeServicio() {
    }

    public personalDeServicio(String seccionAsignada, String anioIncorporacion, int numeroDespachoAsignado, String nombre, String apellido, Integer identificacion, String estadoCivil) {
        super(anioIncorporacion, numeroDespachoAsignado, nombre, apellido, identificacion, estadoCivil);
        this.seccionAsignada = seccionAsignada;
    }

    public String getSeccionAsignada() {
        return seccionAsignada;
    }

    public void setSeccionAsignada(String seccionAsignada) {
        this.seccionAsignada = seccionAsignada;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSeccion asignada: " + seccionAsignada;
    }

    /*
    Traslado de sección de un empleado del personal de servicio.
     */
    public String seccionAsignada() {
        System.out.println("Que seccion tiene asignada");
        return seccionAsignada = leer.next();
    }

    public String trasladoDeSeccion() {

        System.out.println("Desea cambiar de seccion?"
                + "\n1. si"
                + "\n2. no");

        int respuesta = leer.nextInt();

        if (respuesta == 1) {
            System.out.println("Ingrese la nueva seccion");
            seccionAsignada = leer.next();
        } else if (respuesta == 2) {
            System.out.println("Ok, sigue en " + seccionAsignada);
        }
        return seccionAsignada;
    }
}
