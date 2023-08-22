package ej13guia7.Curso;

/*
cuyos atributos serán: nombreCurso, cantidadHorasPorDia,
cantidadDiasPorSemana, turno (mañana o tarde), precioPorHora y alumnos. Donde
alumnos es un arreglo de tipo String de dimensión 5 (cinco), donde se alojarán los
nombres de cada alumno.
 */
public class Curso {

    private String nombreCurso;
    private int cantidadDeHorasPorDia;
    private int cantidadDeDiasPorSemana;
    private boolean turno;
    private float precioPorHora;
    private String[] alumnos = new String[5]; //aqui estaran los nombres de c/alumno

    public Curso() {
    }

    public Curso(String nombreCurso, int cantidadDeHorasPorDia, int cantidadDeDiasPorSemana, boolean turno, float precioPorHora) {
        this.nombreCurso = nombreCurso;
        this.cantidadDeHorasPorDia = cantidadDeHorasPorDia;
        this.cantidadDeDiasPorSemana = cantidadDeDiasPorSemana;
        this.turno = turno;
        this.precioPorHora = precioPorHora;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public int getCantidadDeHorasPorDia() {
        return cantidadDeHorasPorDia;
    }

    public void setCantidadDeHorasPorDia(int cantidadDeHorasPorDia) {
        this.cantidadDeHorasPorDia = cantidadDeHorasPorDia;
    }

    public int getCantidadDeDiasPorSemana() {
        return cantidadDeDiasPorSemana;
    }

    public void setCantidadDeDiasPorSemana(int cantidadDeDiasPorSemana) {
        this.cantidadDeDiasPorSemana = cantidadDeDiasPorSemana;
    }

    public boolean isTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    public float getPrecioPorHora() {
        return precioPorHora;
    }

    public void setPrecioPorHora(float precioPorHora) {
        this.precioPorHora = precioPorHora;
    }

    public String[] getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(String[] alumnos) {
        this.alumnos = alumnos;
    }

    @Override
    public String toString() {
        return "nombreCurso=" + nombreCurso + "\n cantidadDeHorasPorDia=" + cantidadDeHorasPorDia + "\ncantidadDeDiasPorSemana=" + cantidadDeDiasPorSemana + "\nturno=" + turno + "\nprecioPorHora=" + precioPorHora + "\nalumnos=" + alumnos;
    }

}
