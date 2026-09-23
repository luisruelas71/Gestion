package mx.desarrollo.persistence.dao;

import jakarta.persistence.EntityManager;
import mx.desarrollo.persistence.persistence.AbstractDAO;
import mx.desarrollo.entity.Asignacion;
import java.time.LocalTime;
import java.util.List;

public class AsignacionDAO extends AbstractDAO<Asignacion> {
    private final EntityManager entityManager;

    public AsignacionDAO(EntityManager em) {
        super(Asignacion.class);
        this.entityManager = em;
    }

    public List<Asignacion> obtenerTodos(){
        return entityManager
                .createQuery("SELECT a FROM Asignacion a", Asignacion.class)
                .getResultList();
    }

    public boolean existeTraslape(Integer idProfesor, String dia, LocalTime inicio, LocalTime fin) {
        String jpql = "SELECT COUNT(a) FROM Asignacion a WHERE a.profesor.id = :idProf AND a.diaSemana = :dia " +
                "AND (a.horaInicio < :fin AND a.horaFin > :inicio)";
        Long count = entityManager.createQuery(jpql, Long.class)
                .setParameter("idProf", idProfesor)
                .setParameter("dia", dia)
                .setParameter("inicio", inicio)
                .setParameter("fin", fin)
                .getSingleResult();
        return count > 0;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}