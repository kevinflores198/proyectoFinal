/*
Tenemos una clase padre Animal junto con sus 3 clases hijas Perro, Gato, Caballo.
La clase Animal tendrá como atributos el nombre, alimento, edad y raza del Animal.
Crear un método en la clase Animal a través del cual cada clase hija deberá mostrar luego un
mensaje por pantalla informando de que se alimenta. Generar una clase Main que realice lo
siguiente:
 */
package Caballo;

import herenciasej1.Animal.Animal;

public class caballo extends Animal {


    public caballo(String nombre, String alimento, Integer edad, String razaDelAnimal) {
        super(nombre, alimento, edad, razaDelAnimal);
    }

    @Override
    public void alimentarse() {
        System.out.println("\n----Caballo----"
                + "\nNombre: " + super.nombre
                + "\nEdad: " + super.edad
                + "\nRaza: " + super.razaDelAnimal
                + "\nAlimento: " + super.alimento);
    }
}
