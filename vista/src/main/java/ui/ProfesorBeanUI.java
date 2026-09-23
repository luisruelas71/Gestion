package ui;

import helper.ProfesorHelper;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import mx.desarrollo.entity.Profesor;
import java.io.Serializable;
import java.util.List;

@Named("profesorUI")
@ViewScoped
public class ProfesorBeanUI implements Serializable {
    private ProfesorHelper profesorHelper;
    private Profesor profesor;
    private List<Profesor> listaProfesores;

    public ProfesorBeanUI() {
        profesorHelper = new ProfesorHelper();
    }

    @PostConstruct
    public void init() {
        profesor = new Profesor();
        cargarDatos();
    }

    public void cargarDatos() {
        listaProfesores = profesorHelper.findAllProfesores();
    }

    public void cargarProfesores() {
        cargarDatos();
    }

    public void guardar() {
        try {
            profesorHelper.saveProfesor(profesor);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "Profesor registrado correctamente"));
            init();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
        }
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public List<Profesor> getListaProfesores() {
        return listaProfesores;
    }

    public void setListaProfesores(List<Profesor> listaProfesores) {
        this.listaProfesores = listaProfesores;
    }
}