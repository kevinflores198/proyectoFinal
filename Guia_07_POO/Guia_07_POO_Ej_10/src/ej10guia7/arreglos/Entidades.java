package Ej10guia7.arreglos;

public class Entidades {

    private double[] A = new double [50];
    private double[] B = new double [20];

    public Entidades() {
    }

    public Entidades(double[] A, double[] B) {
        this.A = A;
        this.B = B;

    }

    public double[] getA() {
        return A;
    }

    public void setA(double[] A) {
        this.A = A;
    }

    public double[] getB() {
        return B;
    }

    public void setB(double[] B) {
        this.B = B;
    }

    @Override
    public String toString() {
        return "Entidades{" + "A=" + A + ", B=" + B + '}';
    }

}
