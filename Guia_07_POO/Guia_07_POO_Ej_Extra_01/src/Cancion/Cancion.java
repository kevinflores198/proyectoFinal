package Cancion;

public class Cancion {

    private String titulo;
    private String cancion;

    public Cancion() {
    }

    public Cancion(String titulo, String cancion) {
        this.titulo = titulo;
        this.cancion = cancion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCancion() {
        return cancion;
    }

    public void setCancion(String cancion) {
        this.cancion = cancion;
    }

}
