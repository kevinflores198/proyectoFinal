package Libro;

/*-----------------------creamos la clase libro-------------------------------*/

public class Libro1 {

/*-------------------------------atributos------------------------------------*/
    
    private int ISBN;
    private int paginas;
    private String autor;
    private String titulo;

/*----------------------------constructor vacio-------------------------------*/
    
    public Libro1() {
    }
    
/*-----------------constructor pasado por parametros--------------------------*/
    
    public Libro1(int ISBN, String titulo, String autor, int paginas) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
    }
    
/*------------------------------SET-------------------------------------------*/
    
    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public void settitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setautor(String autor) {
        this.autor = autor;
    }

    public void setpaginas(int paginas) {
        this.paginas = paginas;
    }
    
/*------------------------------GET-------------------------------------------*/
    
    public int getISBN() {
        return ISBN;
    }

    public String getautor() {
        return autor;
    }

    public String gettitulo() {
        return titulo;
    }

    public int getpaginas() {
        return paginas;
    }

}
