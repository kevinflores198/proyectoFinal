package relacionesextrasej2.persona;

public class Persona {

    private String nombre;
    private int edad;
    private int dinero;
    private boolean entrada;

    public Persona() {
    }

    public Persona(String nombre, int edad, int dinero, boolean entrada) {
        this.nombre = nombre;
        this.edad = edad;
        this.dinero = dinero;
        this.entrada = entrada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public boolean isEntrada() {
        return entrada;
    }

    public void setEntrada(boolean entrada) {
        this.entrada = entrada;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", edad=" + edad + ", dinero=" + dinero + ", entrada=" + entrada + '}';
    }

}
