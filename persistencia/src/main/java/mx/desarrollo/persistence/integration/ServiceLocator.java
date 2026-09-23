package mx.desarrollo.persistence.integration;

import jakarta.persistence.EntityManager;
import mx.desarrollo.persistence.dao.UsuarioDAO;
import mx.desarrollo.persistence.dao.ProfesorDAO;
import mx.desarrollo.persistence.dao.UnidadAprendizajeDAO;
import mx.desarrollo.persistence.dao.AsignacionDAO;
import mx.desarrollo.persistence.persistence.HibernateUtil;

public class ServiceLocator {

    private static EntityManager entityManager;

    private static synchronized EntityManager getEntityManager(){
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = HibernateUtil.getEntityManager();
        }
        return entityManager;
    }

    public static UsuarioDAO getInstanceUsuarioDAO(){
        return new UsuarioDAO(getEntityManager());
    }

    public static ProfesorDAO getInstanceProfesorDAO(){
        return new ProfesorDAO(getEntityManager());
    }

    public static UnidadAprendizajeDAO getInstanceUnidadAprendizajeDAO(){
        return new UnidadAprendizajeDAO(getEntityManager());
    }

    public static AsignacionDAO getInstanceAsignacionDAO(){
        return new AsignacionDAO(getEntityManager());
    }
}