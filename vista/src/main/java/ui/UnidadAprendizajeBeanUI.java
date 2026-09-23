package ui;

import helper.UnidadAprendizajeHelper;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import mx.desarrollo.entity.UnidadAprendizaje;
import java.io.Serializable;
import java.util.List;

@Named("unidadUI")
@ViewScoped
public class UnidadAprendizajeBeanUI implements Serializable {
    private UnidadAprendizajeHelper unidadHelper;
    private UnidadAprendizaje unidad;
    private List<UnidadAprendizaje> listaUnidades;

    public UnidadAprendizajeBeanUI() {
        unidadHelper = new UnidadAprendizajeHelper();
    }

    @PostConstruct
    public void init() {
        unidad = new UnidadAprendizaje();
        cargarUnidades();
    }

    public void cargarUnidades() {
        listaUnidades = unidadHelper.findAllUnidades();
    }

    public void guardar() {
        try {
            if (unidad.getId() == null) {
                unidadHelper.saveUnidad(unidad);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "Unidad registrada"));
            } else {
                unidadHelper.updateUnidad(unidad);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "Unidad actualizada"));
            }
            init();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
        }
    }

    public void eliminar(UnidadAprendizaje u) {
        try {
            unidadHelper.deleteUnidad(u);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "Unidad eliminada"));
            cargarUnidades();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo eliminar"));
        }
    }

    public void prepararEdicion(UnidadAprendizaje u) {
        this.unidad = u;
    }

    public UnidadAprendizaje getUnidad() {
        return unidad;
    }

    public void setUnidad(UnidadAprendizaje unidad) {
        this.unidad = unidad;
    }

    public List<UnidadAprendizaje> getListaUnidades() {
        return listaUnidades;
    }

    public void setListaUnidades(List<UnidadAprendizaje> listaUnidades) {
        this.listaUnidades = listaUnidades;
    }
}