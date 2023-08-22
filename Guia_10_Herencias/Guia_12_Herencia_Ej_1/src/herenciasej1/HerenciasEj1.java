/*
Tenemos una clase padre Animal junto con sus 3 clases hijas Perro, Gato, Caballo.
La clase Animal tendrá como atributos el nombre, alimento, edad y raza del Animal.
Crear un método en la clase Animal a través del cual cada clase hija deberá mostrar luego un
mensaje por pantalla informando de que se alimenta. Generar una clase Main que realice lo
siguiente:
 */
package herenciasej1;

import Caballo.caballo;
import Gato.gato;
import Perro.Perro;
import herenciasej1.Animal.Animal;

public class HerenciasEj1 {

    public static void main(String[] args) {

        Animal perro1 = new Perro("pichulo", "Doggy", 5, "Salchicha");

        perro1.alimentarse();

        Animal caballo1 = new caballo("Sebastian", "pasto", 7, "Carretelero");

        caballo1.alimentarse();

        Animal gato1 = new gato("Michi", "Wiskas", 4, "Naranjoso");

        gato1.alimentarse();
        
    }

}
