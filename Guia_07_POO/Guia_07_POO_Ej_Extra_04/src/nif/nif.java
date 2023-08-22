package nif;

public class nif {

    private int dni;
    private String letra;
    private float[] n = new float[22];

    public float[] getN() {
        return n;
    }

    public void setN(float[] n) {
        this.n = n;
    }

    public nif() {
    }

    public nif(int dni, String letra) {
        this.dni = dni;
        this.letra = letra;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    @Override
    public String toString() {
        return "nif{" + "dni=" + dni + ", letra=" + letra + '}';
    }

}
