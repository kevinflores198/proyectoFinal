/*
• Por cada persona, se debe conocer, al menos, su nombre y apellidos, su número de
identificación y su estado civil.
 */
package herenciasextrasej4.entidades;

import java.util.Scanner;

public class persona {

    protected String nombre;
    protected String apellido;
    protected Integer identificacion;
    protected String estadoCivil;

    Scanner leer = new Scanner(System.in);

    public persona() {
    }

    public persona(String nombre, String apellido, Integer identificacion, String estadoCivil) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.estadoCivil = estadoCivil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Integer identificacion) {
        this.identificacion = identificacion;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    @Override
    public String toString() {
        return "\nNombre: " + nombre + "\nApellido: " + apellido + "\nNumero de identificacion: " + identificacion + "\nEstado civil: " + estadoCivil;
    }

    public void crearPersona() {
        System.out.println("Ingrese el nombre: ");
        nombre = leer.next();
        System.out.println("Ingrese el apellido:");
        apellido = leer.next();
        System.out.println("Ingrese el DNI");
        identificacion = leer.nextInt();
        estadoCivil();

    }

    public String estadoCivil() {
        System.out.println("Ingrese estado civil:");
        return estadoCivil = leer.next();
    }

    public String cambiarEstadoCivil() {
        
        System.out.println("Desea cambiar su estado civil?"
                + "\n1. si"
                + "\n2. no");

        int respuesta = leer.nextInt();

        if (respuesta == 1) {

            System.out.println("Ingrese el nuevo estado civil");

            estadoCivil = leer.next();

        } else if (respuesta == 2) {

            System.out.println("Ok, su estado civil sigue siendo " + estadoCivil);
        }
        return estadoCivil;
    }

}
