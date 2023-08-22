package javamascota.encontrar;

public class Mascota {

    private String Nombre;
    private String Apodo;
    private String Tipo;
    private String Color;
    private int Edad;
    private boolean Cola;
    private String Raza;

    private int energia;

    public Mascota() {
        this.energia = 1000;
    }

    public Mascota(String Nombre, String Apodo, String Tipo) {
        this.Nombre = Nombre;
        this.Apodo = Apodo;
        if (Tipo.equals("Perro") || Tipo.equals("Gato") || Tipo.equals("Loro") || Tipo.equals("Conejo") || Tipo.equals("Carpincho")) {
            this.Tipo = Tipo;
        }
        this.energia = 1000;
    }

    public void setNombre(String nombre) {

        if (nombre.length() > 0) {
            this.Nombre = nombre;
        }
    }

    public void setApodo(String apodo) {
        this.Apodo = apodo;
    }

    public void setTipo(String tipo) {
        this.Tipo = tipo;
    }

    public void setColor(String color) {
        this.Color = color;
    }

    public void setEdad(int edad) {
        this.Edad = edad;
    }

    public void setCola(boolean cola) {
        this.Cola = cola;
    }

    public void setRaza(String raza) {
        this.Raza = raza;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApodo() {
        return Apodo;
    }

    public String getTipo() {
        return Tipo;
    }

    public String getColor() {
        return Color;
    }

    public int getEdad() {
        return Edad;
    }

    public boolean isCola() {
        return Cola;
    }

    public String getRaza() {
        return Raza;
    }
/**
 * funcion asignada a pasear
 * @param energiaRestar
 * @return 
 */
    public int pasear(int energiaRestar) {

        energia -= energiaRestar;

        return energia;
    }
/**
 * funcion destinada a pasear por vueltas
 * @param energiaRestar
 * @param vueltas
 * @return energia
 */
    public int pasear(int energiaRestar, int vueltas) {

        for (int i = 0; i < vueltas; i++) {
            energia -= energiaRestar;

        }
        return energia;
    }

    @Override
    public String toString() {
        return "\nMascota{" + "Nombre=" + Nombre + ", Apodo=" + Apodo + ", Tipo=" + Tipo + ", Color=" + Color + ", Edad=" + Edad + ", Cola=" + Cola + ", Raza=" + Raza + ", energia=" + energia + '}';
    }

}
