package ui;

import helper.LoginHelper;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import mx.desarrollo.entity.Usuario;
import java.io.IOException;
import java.io.Serializable;

@Named("loginUI")
@SessionScoped
public class LoginBeanUI implements Serializable {
    private LoginHelper loginHelper;
    private Usuario usuario;

    public LoginBeanUI() {
        loginHelper = new LoginHelper();
    }

    @PostConstruct
    public void init() {
        usuario = new Usuario();
    }

    public void login() throws IOException {
        String appURL = "/menu.xhtml";
        Usuario us = loginHelper.login(usuario.getUsername(), usuario.getPassword());
        if(us != null && us.getId() != null) {
            usuario = us;
            FacesContext.getCurrentInstance().getExternalContext().redirect(
                    FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + appURL);
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Credenciales incorrectas", "Intente de nuevo"));
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}