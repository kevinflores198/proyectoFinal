package Persistencia;

import entidades.Autor;
import java.util.List;
import java.util.Scanner;

public class DAOAutor extends DAO<Autor> {

    Scanner leer = new Scanner(System.in);

    /**
     *
     * @param autor
     */
    @Override
    public void guardar(Autor autor) {
        super.guardar(autor);
    }

    public void eliminar(Integer id) throws Exception {
        Autor autor = buscarPorId(id);
        if (true) {
            super.eliminar(autor);
            System.out.println("El autor se elimino correctamente");
        } else {
            System.out.println("El autor que quere eliminar aun no existe o ha sido eliminado anteriormente");
        }

    }

    public Autor buscarPorId(Integer id) throws Exception {
        conectar();
        Autor autor = em.find(Autor.class, id);
        desconectar();
        return autor;
    }

    public void editar(Integer id) throws Exception {
        Autor autor = buscarPorId(id);
        int respuesta;
        do {
            System.out.println("Que desea editar?"
                    + "\n1. id"
                    + "\n2. nombre"
                    + "\n3. alta");
            respuesta = leer.nextInt();
            switch (respuesta) {
                case 1:
                    System.out.println("Ingrese el nuevo id");
                    autor.setId(leer.nextInt());
                    super.editar(autor);
                    System.out.println("Se ha actualizado el id del sistema");
                    break;
                case 2:
                    System.out.println("Ingrese el nuevo nombre");
                    autor.setNombre(leer.next());
                    super.editar(autor);
                    System.out.println("Se ha actualizado el nombre del sistema");
                    break;
                case 3:
                    System.out.println("Ingrese el nuevo numero alta");
                    autor.setAlta(leer.nextBoolean());
                    super.editar(autor);
                    System.out.println("Se ha actualizado el alta del sistema");
                    break;
            }
            System.out.println("Desea seguir modificando algun otro autor?"
                    + "\n1. Si"
                    + "\n2. No");
            respuesta = leer.nextInt();
            super.editar(autor);
        } while (respuesta == 1);

    }

    public List<Autor> listarTodos() throws Exception {
        conectar();
        List<Autor> autores = em.createQuery("Select a from Libro a").getResultList();
        desconectar();
        return autores;
    }

}
