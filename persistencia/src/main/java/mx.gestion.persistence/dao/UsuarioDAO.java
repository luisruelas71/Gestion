package mx.gestion.persistence.dao;

import mx.gestion.entidad.Usuario;
import mx.gestion.persistence.persistence.AbstractDAO;

public class UsuarioDAO extends AbstractDAO<Usuario> {

    public UsuarioDAO() {
        super(Usuario.class);
    }
}