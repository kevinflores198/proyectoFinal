package HerenciasEj4Segundo.entidades;

import java.util.Scanner;

public class empleado extends persona {

    protected int incorporacion;
    protected int despacho;
    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public empleado() {
    }

    public empleado(int incorporacion, int despacho, String nombreCompleto, int dni, String estadoCivil) {
        super(nombreCompleto, dni, estadoCivil);
        this.incorporacion = incorporacion;
        this.despacho = despacho;
    }

    public int getIncorporacion() {
        return incorporacion;
    }

    public void setIncorporacion(int incorporacion) {
        this.incorporacion = incorporacion;
    }

    public int getDespacho() {
        return despacho;
    }

    public void setDespacho(int despacho) {
        this.despacho = despacho;
    }

    @Override
    public String toString() {
        return super.toString() + "\nIncorporacion: " + incorporacion + "\nDespacho: " + despacho;
    }

    public void incorporacionYDespacho() {
        System.out.print("En que año comenzo a trabajar aqui?: ");
        incorporacion = leer.nextInt();
        System.out.print("Ingrese numero de despacho: ");
        despacho = leer.nextInt();
    }

    public void cambiarDatosEmpleado() {
        super.cambiarEstadoCivil();
        System.out.print("Cual sera el nuevo despacho? ");
        despacho = leer.nextInt();
    }

}
