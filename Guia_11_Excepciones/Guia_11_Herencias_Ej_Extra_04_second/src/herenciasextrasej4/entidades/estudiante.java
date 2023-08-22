package herenciasextrasej4.entidades;

/**
 * • En cuanto a los estudiantes, se requiere almacenar el curso en el que están
 * matriculados.
 */
public class estudiante extends persona {

    private String curso;

    public estudiante() {
    }

    public estudiante(String curso, String nombre, String apellido, Integer identificacion, String estadoCivil) {
        super(nombre, apellido, identificacion, estadoCivil);
        this.curso = curso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCurso: " + curso;
    }

    @Override
    public String estadoCivil() {
        return super.estadoCivil();
    }

    @Override
    public String cambiarEstadoCivil() {
        return super.cambiarEstadoCivil(); //To change body of generated methods, choose Tools | Templates.
    }

    /*
    Matriculación de un estudiante en un nuevo curso.
     */
    public String matriculacion() {
        System.out.println("Que matricua esta?");
        return curso = leer.next();
    }

    public String cambiarMatriculacion() {
        System.out.println("Desea cambiar la matricula?"
                + "\n1. si"
                + "\n2. no");

        int respuesta = leer.nextInt();

        if (respuesta == 1) {
            System.out.println("Ingrese la nueva matricula");
            curso = leer.next();
        } else if (respuesta == 2) {
            System.out.println("Ok, sigue en " + curso);
        }
        return curso;
    }
}
