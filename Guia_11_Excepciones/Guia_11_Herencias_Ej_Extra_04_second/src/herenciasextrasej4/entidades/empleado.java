/*

 */
package herenciasextrasej4.entidades;

/**
 * • Con respecto a los empleados, sean del tipo que sean, hay que saber su año
 * de incorporación a la facultad y qué número de despacho tienen asignado.
 *
 */
public class empleado extends persona {

    protected String anioIncorporacion;
    protected int numeroDespachoAsignado;

    public empleado() {
    }

    public empleado(String anioIncorporacion, int numeroDespachoAsignado, String nombre, String apellido, Integer identificacion, String estadoCivil) {
        super(nombre, apellido, identificacion, estadoCivil);
        this.anioIncorporacion = anioIncorporacion;
        this.numeroDespachoAsignado = numeroDespachoAsignado;
    }

    public String getAnioIncorporacion() {
        return anioIncorporacion;
    }

    public void setAnioIncorporacion(String anioIncorporacion) {
        this.anioIncorporacion = anioIncorporacion;
    }

    public int getNumeroDespachoAsignado() {
        return numeroDespachoAsignado;
    }

    public void setNumeroDespachoAsignado(int numeroDespachoAsignado) {
        this.numeroDespachoAsignado = numeroDespachoAsignado;
    }

    @Override
    public String toString() {
        return super.toString() + "\nAño de incorpiracion: " + anioIncorporacion + "\nNumero de despacho asignado: " + numeroDespachoAsignado;
    }

    /*
• Con respecto a los empleados, sean del tipo que sean, hay que saber su año de
incorporación a la facultad y qué número de despacho tienen asignado.
    
Reasignación de despacho a un empleado.

     */
    @Override
    public String estadoCivil() {
        return super.estadoCivil();
    }

    @Override
    public String cambiarEstadoCivil() {
        return super.cambiarEstadoCivil();
    }

    public void infoEmpleado() {
        System.out.println("Ingrese su año de incorporacion a la facultad");
        anioIncorporacion = leer.next();
        System.out.println("Ingrese su numero de despacho");
        numeroDespachoAsignado = leer.nextInt();
    }

    public int reasignacion() {
        System.out.println("Desea cambiar de despacho?"
                + "\n1. si"
                + "\n2. no");

        int respuesta = leer.nextInt();

        if (respuesta == 1) {
            System.out.println("Ingrese la nueva matricula");
            numeroDespachoAsignado = leer.nextInt();
        } else if (respuesta == 2) {
            System.out.println("Ok, sigue en " + numeroDespachoAsignado);
        }
        return numeroDespachoAsignado;
    }
}
