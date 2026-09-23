package helper;

import mx.desarrollo.entity.Usuario;
import mx.desarrollo.integration.ServiceFacadeLocator;
import java.io.Serializable;

public class LoginHelper implements Serializable {
    public Usuario login(String username, String password) {
        return ServiceFacadeLocator.getInstanceFacadeUsuario().login(password, username);
    }
}