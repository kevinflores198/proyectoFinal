
package Persistencia;

import entidades.Editorial;
import java.util.List;
import java.util.Scanner;


public class DAOEditorial extends DAO<Editorial>{
Scanner leer = new Scanner(System.in);

    /**
     *
     * @param editorial
     */
    @Override
    public void guardar(Editorial editorial) {
        super.guardar(editorial);
    }

    public void eliminar(Integer id) throws Exception {
        Editorial editorial = buscarPorId(id);
        if (true) {
            super.eliminar(editorial);
            System.out.println("El editorial se elimino correctamente");
        } else {
            System.out.println("El editorial que quere eliminar aun no existe o ha sido eliminado anteriormente");
        }
    }
    
        public void editar(Integer id) throws Exception {
        Editorial editorial = buscarPorId(id);
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
                    editorial.setId(leer.nextInt());
                    super.editar(editorial);
                    System.out.println("Se ha actualizado el id del sistema");
                    break;
                case 2:
                    System.out.println("Ingrese el nuevo nombre");
                    editorial.setNombre(leer.next());
                    super.editar(editorial);
                    System.out.println("Se ha actualizado el nombre del sistema");
                    break;
                case 3:
                    System.out.println("Ingrese el nuevo numero alta");
                    editorial.setAlta(leer.nextBoolean());
                    super.editar(editorial);
                    System.out.println("Se ha actualizado el alta del sistema");
                    break;
            }
            System.out.println("Desea seguir modificando alguna otra editorial?"
                    + "\n1. Si"
                    + "\n2. No");
            respuesta = leer.nextInt();
            super.editar(editorial);
        } while (respuesta == 1);
    }

    public Editorial buscarPorId(Integer id) throws Exception {
        conectar();
        Editorial editorial = em.find(Editorial.class, id);
        desconectar();
        return editorial;
    }

    public List<Editorial> listarTodos() throws Exception {
        conectar();
        List<Editorial> editoriales = em.createQuery("Select e from Editorial e").getResultList();
        desconectar();
        return editoriales;
    }
}
