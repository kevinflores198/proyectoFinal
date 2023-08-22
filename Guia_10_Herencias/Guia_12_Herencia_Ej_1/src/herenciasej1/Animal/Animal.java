/*
Tenemos una clase padre Animal junto con sus 3 clases hijas Perro, Gato, Caballo.
La clase Animal tendrá como atributos el nombre, alimento, edad y raza del Animal.
Crear un método en la clase Animal a través del cual cada clase hija deberá mostrar luego un
mensaje por pantalla informando de que se alimenta. Generar una clase Main que realice lo
siguiente:
 */
package herenciasej1.Animal;

public abstract class Animal {

    protected String nombre;
    protected String alimento;
    protected Integer edad;
    protected String razaDelAnimal;

    public Animal() {
    }

    public Animal(String nombre, String alimento, Integer edad, String razaDelAnimal) {
        this.nombre = nombre;
        this.alimento = alimento;
        this.edad = edad;
        this.razaDelAnimal = razaDelAnimal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlimento() {
        return alimento;
    }

    public void setAlimento(String alimento) {
        this.alimento = alimento;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getRazaDelAnimal() {
        return razaDelAnimal;
    }

    public void setRazaDelAnimal(String razaDelAnimal) {
        this.razaDelAnimal = razaDelAnimal;
    }

    public abstract void alimentarse();

}
