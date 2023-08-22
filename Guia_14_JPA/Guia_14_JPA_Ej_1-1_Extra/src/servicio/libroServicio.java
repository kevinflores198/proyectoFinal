package servicio;

import Persistencia.DAOLibro;
import entidades.Autor;
import entidades.Editorial;
import entidades.Libro;
import java.util.List;
import java.util.Scanner;

public class libroServicio extends DAOLibro {

    Scanner leer = new Scanner(System.in);

    DAOLibro daoLibro = new DAOLibro();

    int menu;

    public Libro crearLibro() {
        do {
            Libro libro = new Libro();
            try {
                System.out.println("Nuevo libro: \n");
                System.out.print("\nIngrese el titulo: ");
                libro.setTitulo(leer.next());
                System.out.print("\nIngrese el año: ");
                libro.setAnio(leer.nextInt());
                System.out.print("\nIngrese el numero de ejemplares: ");
                libro.setEjemplares(leer.nextInt());
                System.out.print("\nIngrese el numero de ejemplares prestados: ");
                libro.setEjemplaresPrestados(leer.nextInt());
                System.out.print("\nIngrese el numero de ejemplares restantes: ");
                libro.setEjemplaresRestantes(leer.nextInt());
                System.out.print("\nIngrese el alta: ");
                libro.setAlta(leer.nextBoolean());

                super.guardarLibro(libro);

                System.out.println("\nDesea crear otro libro? (1. Si / 2. No)");
                menu = leer.nextInt();

                return libro;

            } catch (Exception e) {
                System.out.println("\nError al crear un libro");
                System.out.println(e.getMessage());
                System.out.println("\nDesea crear otro libro? (1. Si / 2. No)");
                menu = leer.nextInt();
                return null;
            }
        } while (menu == 1);
    }

    public void editarLibro(Long isbn) {
        try {
            Libro libro = buscarLibro(isbn);
            int respuesta;
            do {
                System.out.println("Que desea editar?"
                        + "\n1. ISBN"
                        + "\n2. Anio"
                        + "\n3. Ejemplares"
                        + "\n4. Ejemplares prestados"
                        + "\n5. Ejemplares restantes"
                        + "\n6. Alta");
                respuesta = leer.nextInt();
                switch (respuesta) {
                    case 1:
                        System.out.println("Ingrese el nuevo ISBN");
                        libro.setIsbn(leer.nextLong());
                        editarLibro(libro);
                        System.out.println("Se ha actualizado el ISBN del sistema");
                        break;
                    case 2:
                        System.out.println("Ingrese el nuevo anio");
                        libro.setAnio(leer.nextInt());
                        editarLibro(libro);
                        System.out.println("Se ha actualizado el anio del sistema");
                        break;
                    case 3:
                        System.out.println("Ingrese el nuevo numero de ejemplares");
                        libro.setEjemplares(leer.nextInt());
                        editarLibro(libro);
                        System.out.println("Se ha actualizado el numero de ejemplares del sistema");
                        break;
                    case 4:
                        System.out.println("Ingrese el nuevo numero de ejemplares prestados");
                        libro.setEjemplaresPrestados(leer.nextInt());
                        editarLibro(libro);
                        System.out.println("Se ha actualizado el numero de ejemplares prestados del sistema");
                        break;
                    case 5:
                        System.out.println("Ingrese el nuevo ejemplares restantes");
                        libro.setEjemplaresRestantes(leer.nextInt());
                        editarLibro(libro);
                        System.out.println("Se ha actualizado el numero de ejemplares restantes del sistema");
                        break;
                    case 6:
                        System.out.println("Ingrese el nuevo alta");
                        libro.setAlta(leer.nextBoolean());
                        editarLibro(libro);
                        System.out.println("Se ha actualizado el alta del sistema");
                        break;
                }
                System.out.println("Desea hacer algo?"
                        + "\n1. Si"
                        + "\n2. No");
                respuesta = leer.nextInt();
            } while (respuesta == 1);
        } catch (Exception e) {
            System.out.println("error al modificar el libro");
            System.out.println(e.getMessage());
        }
    }

    public void eliminarLibro(Long isbn) {
        try {

            eliminarLibro(buscarLibroISBN(isbn));
        } catch (Exception e) {
            System.out.println("\nerror al eliminar libro");
            System.out.println(e.getMessage());
        }
    }

    public Libro buscarLibroISBN(Long isbn) {
        System.out.println(buscarLibro(isbn));
        return daoLibro.buscarLibro(isbn);
    }

    @Override
    public Libro buscarLibroTitulo(String titulo) {
        System.out.println(buscarLibroTitulo(titulo));
        return daoLibro.buscarLibroTitulo(titulo);
    }

    /**
     *
     * @param autor
     * @return
     */
    public Libro buscarLibroAutor(Autor autor) {
        System.out.println(buscarLibroPorAutor(autor));
        return daoLibro.buscarLibroPorAutor(autor);
    }

    public Libro buscarLibroEditorial(Editorial editorial) {
        System.out.println(buscarLibroPorEditorial(editorial));
        return daoLibro.buscarLibroPorEditorial(editorial);
    }

    @Override
    public List<Libro> listarLibros() {
        try {
            return daoLibro.listarLibros();
        } catch (Exception e) {
            System.out.println("error al listar los libros");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void menuLibro(Libro libro) throws Exception {
        Autor autor= null;
        Editorial editorial;
        do {
            System.out.print("\n1. Generar libro"
                    + "\n2. Modificar libro"
                    + "\n3. Eliminar libro"
                    + "\n4. Buscar por ISBN"
                    + "\n5. Buscar por titulo"
                    + "\n6. Buscar por autor"
                    + "\n7. Buscar por editorial"
                    + "\n8. Salir\n> ");
            menu = leer.nextInt();
            switch (menu) {
                case 1:
                    crearLibro();
                    break;
                case 2:
                    //editarLibro();
                    break;
                case 3:
                    System.out.println("Ingrese el isbn del libro que desea eliminar");
                    eliminarLibro(leer.nextLong());
                    break;
                case 4:
                    System.out.println("Buscar libro por ISBN");
                    buscarLibroISBN(leer.nextLong());
                    break;
                case 5:
                    System.out.println("Buscar libro por titulo");
                    buscarLibroTitulo(leer.next());
                    break;
                case 6:
                    System.out.println("buscar libro por nombre de autor");
                    buscarLibroAutor(autor);
                    break;
                case 7:
                    buscarLibroEditorial(null);
                    break;
                case 8:
                    System.out.println("Chau");
                    break;

            }

            System.out.println("Desea seguir ?"
                    + "\n1. Si"
                    + "\n2. No");
            menu = leer.nextInt();
        } while (menu == 1);
    }
}
