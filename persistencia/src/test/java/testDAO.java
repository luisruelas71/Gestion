import mx.desarrollo.persistence.persistence.HibernateUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

import mx.desarrollo.entity.Profesor;

public class testDAO {
    public static void main(String[] args) {
        try {
            EntityManager em = HibernateUtil.getEntityManager();
            System.out.println("Conexion establecida a la base de datos");

            List<Profesor> profesores = em.createQuery("SELECT p FROM Profesor p", Profesor.class).getResultList();

            for (Profesor profesor : profesores) {
                System.out.println(profesor.getNombre() + " " + profesor.getApellidoPaterno() + " | ID: " + profesor.getId());
            }

            System.out.println("Prueba finalizada");

        } catch (Exception e) {
            System.out.println("Fallo la conexion");
            e.printStackTrace();
        }
    }
}