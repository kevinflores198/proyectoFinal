package Cadena;

public class Cadena {

    private String frase;
    private int largoCadena;

    public Cadena() {
    }

    public Cadena(String frase, int largoCadena) {
        this.frase = frase;
        this.largoCadena = largoCadena;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    public int getLargoCadena() {
        return largoCadena;
    }

    public void setLargoCadena(int largoCadena) {
        this.largoCadena = largoCadena;
    }

    @Override
    public String toString() {
        return "Cadena{" + "frase=" + frase + ", largoCadena=" + largoCadena + '}';
    }

}
