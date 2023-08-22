package Ahorcado;

public class Ahorcado {
//Atributos

    private char[] buscar = new char[30];
    private int letraAcertada;
    private int jugadasMaxima;
    private String letra;

//Metodos

    public Ahorcado() {
    }

    public Ahorcado(int letraAcertada, int jugadasMaxima) {
        this.letraAcertada = letraAcertada;
        this.jugadasMaxima = jugadasMaxima;
        
    }

    public Ahorcado(String letra) {
        this.letra = letra;
    }

    public char[] getBuscar() {
        return buscar;
    }

    public void setBuscar(char[] buscar) {
        this.buscar = buscar;
    }

    public int getLetraAcertada() {
        return letraAcertada;
    }

    public void setLetraAcertada(int letraAcertada) {
        this.letraAcertada = letraAcertada;
    }

    public int getJugadasMaxima() {
        return jugadasMaxima;
    }

    public void setJugadasMaxima(int jugadasMaxima) {
        this.jugadasMaxima = jugadasMaxima;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

}
