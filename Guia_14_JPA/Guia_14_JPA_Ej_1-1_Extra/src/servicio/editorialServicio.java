package servicio;

import Persistencia.DAOEditorial;
import entidades.Editorial;
import java.util.List;

public class editorialServicio {

    private libroServicio libroS;
    private autorServicio autorS;

    public DAOEditorial daoEditorial;

    public editorialServicio() {
        this.daoEditorial = new DAOEditorial();
    }

    public void serServicios(libroServicio libroS, autorServicio autorS) {
        this.libroS = libroS;
        this.autorS = autorS;
    }

    public Editorial crearEditorial(String nombre, Boolean alta) {

        Editorial editorial = new Editorial();

        try {
            editorial.setNombre(nombre);
            editorial.setAlta(alta);

            return editorial;

        } catch (Exception e) {
            System.out.println("Error al crear una editorial");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Editorial buscarPorIDServicio(Integer id) {
        try {
            return daoEditorial.buscarPorId(id);
        } catch (Exception e) {
            System.out.println("error al buscar por id");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Boolean eliminarPorID(Integer id) {
        try {
            daoEditorial.eliminar(id);
            return true;
        } catch (Exception e) {
            System.out.println("error al eliminar por id");
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void modificarPorID(Integer id) {
        try {
            daoEditorial.editar(id);
        } catch (Exception e) {
            System.out.println("error al modificar por id");
            System.out.println(e.getMessage());
        }
    }

    public List<Editorial> listarEditoriales() {
        try {
            return daoEditorial.listarTodos();
        } catch (Exception e) {
            System.out.println("error al listar las editoriales");
            System.out.println(e.getMessage());
            return null;
        }
    }

}
