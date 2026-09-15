package mx.gestion.persistence.dao;

import mx.gestion.entidad.Profesore;
import mx.gestion.persistence.persistence.AbstractDAO;

public class ProfesorDAO extends AbstractDAO<Profesore> {

    public ProfesorDAO() {
        super(Profesore.class);
    }
}