package servicio;

import Persistencia.DAOAutor;
import entidades.Autor;
import java.util.List;

public class autorServicio {

    private libroServicio libroS;
    private editorialServicio editorialS;

    public DAOAutor daoAutor;

    public autorServicio() {
        this.daoAutor = new DAOAutor();
    }

    public void serServicios(libroServicio libroS, editorialServicio editorialS) {
        this.libroS = libroS;
        this.editorialS = editorialS;
    }

    public Autor crearLibro(String nombre, Boolean alta) {

        Autor autor = new Autor();

        try {
            autor.setNombre(nombre);
            autor.setAlta(alta);

            return autor;

        } catch (Exception e) {
            System.out.println("Error al crear un autor");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Autor buscarPorIDServicio(Integer id) {
        try {
            return daoAutor.buscarPorId(id);
        } catch (Exception e) {
            System.out.println("error al buscar por id");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Boolean eliminarPorID(Integer id) {
        try {
            daoAutor.eliminar(id);
            return true;
        } catch (Exception e) {
            System.out.println("error al eliminar por id");
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void modificarPorISBN(Integer id) {
        try {
            daoAutor.editar(id);
        } catch (Exception e) {
            System.out.println("error al modificar por id");
            System.out.println(e.getMessage());
        }
    }

    public List<Autor> listarAutores() {
        try {
            return daoAutor.listarTodos();
        } catch (Exception e) {
            System.out.println("error al listar los autores");
            System.out.println(e.getMessage());
            return null;
        }
    }

}
