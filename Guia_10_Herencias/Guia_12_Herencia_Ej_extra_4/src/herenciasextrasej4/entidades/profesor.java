/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herenciasextrasej4.entidades;

/**
 * • Por lo que se refiere a los profesores, es necesario gestionar a qué
 * departamento pertenecen (lenguajes, matemáticas, arquitectura, ...).
 */
public class profesor extends empleado {

    private String departamento;

    public profesor() {
        super();
    }

    public profesor(String departamento, String anioIncorporacion, int numeroDespachoAsignado, String nombre, String apellido, Integer identificacion, String estadoCivil) {
        super(anioIncorporacion, numeroDespachoAsignado, nombre, apellido, identificacion, estadoCivil);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return super.toString() + "\nDepartamento: " + departamento;
    }

    /*
    Cambio de departamento de un profesor.
     */
    public String departamento() {
        System.out.println("A que departamento pertenece?");
        return departamento = leer.next();
    }

    public String cambioDepartamento() {

        System.out.println("Desea cambiar de departamento?"
                + "\n1. si"
                + "\n2. no");

        String respuesta = leer.next().toLowerCase();

        if (respuesta.equals("si")) {
            System.out.println("Ingrese el nuevo departamento");
            departamento = leer.next();
        } else if (respuesta.equals("no")) {
            System.out.println("Ok, quedate donde estas");
        }
        return departamento;
    }

}
