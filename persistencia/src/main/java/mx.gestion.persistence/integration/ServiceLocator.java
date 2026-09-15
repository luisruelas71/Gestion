package mx.gestion.persistence.integration;

import mx.gestion.persistence.dao.AsignacionDAO;
import mx.gestion.persistence.dao.ProfesorDAO;
import mx.gestion.persistence.dao.UnidadDao;
import mx.gestion.persistence.dao.UsuarioDAO;

public class ServiceLocator {

    private static ServiceLocator instance;
    private UsuarioDAO usuarioDAO;
    private ProfesorDAO profesorDAO;
    private UnidadDao unidadDao;
    private AsignacionDAO asignacionDAO;

    private ServiceLocator() {
        usuarioDAO = new UsuarioDAO();
        profesorDAO = new ProfesorDAO();
        unidadDao = new UnidadDao();
        asignacionDAO = new AsignacionDAO();
    }

    public static ServiceLocator getInstance() {
        if (instance == null) {
            instance = new ServiceLocator();
        }
        return instance;
    }

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public ProfesorDAO getProfesorDAO() {
        return profesorDAO;
    }

    public UnidadDao getUnidadDao() {
        return unidadDao;
    }

    public AsignacionDAO getAsignacionDAO() {
        return asignacionDAO;
    }
}