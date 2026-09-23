package mx.desarrollo.facade;

import mx.desarrollo.delegate.DelegateUsuario;
import mx.desarrollo.entity.Usuario;

public class FacadeUsuario {
    private final DelegateUsuario delegateUsuario;

    public FacadeUsuario() {
        this.delegateUsuario = new DelegateUsuario();
    }

    public Usuario login(String password, String username){
        return delegateUsuario.login(password, username);
    }

    public void saveUsuario(Usuario usuario){
        delegateUsuario.saveUsuario(usuario);
    }
}