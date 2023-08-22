/*
numeroCuenta (entero), el DNI del cliente (entero largo) y el saldo actual (entero). 
 */
package Cuenta;

public class Bancaria {

    private int numeroCuenta;
    private int DNI;
    private int sueldoActual;

    public Bancaria() {
    }

    public Bancaria(int numeroCuenta, int DNI, int sueldoActual) {
        this.numeroCuenta = numeroCuenta;
        this.DNI = DNI;
        this.sueldoActual = sueldoActual;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public int getSueldoActual() {
        return sueldoActual;
    }

    public void setSueldoActual(int sueldoActual) {
        this.sueldoActual = sueldoActual;
    }

    @Override
    public String toString() {
        return "Bancaria{" + "numeroCuenta=" + numeroCuenta + ", DNI=" + DNI + ", sueldoActual=" + sueldoActual + '}';
    }

}
