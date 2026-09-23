package ui;

import helper.AsignacionHelper;
import helper.ProfesorHelper;
import helper.UnidadAprendizajeHelper;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import mx.desarrollo.entity.Asignacion;
import mx.desarrollo.entity.Profesor;
import mx.desarrollo.entity.UnidadAprendizaje;
import java.io.Serializable;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.List;

@Named("asignacionUI")
@ViewScoped
public class AsignacionBeanUI implements Serializable {
    private AsignacionHelper asignacionHelper;
    private ProfesorHelper profesorHelper;
    private UnidadAprendizajeHelper unidadHelper;
    private Asignacion asignacion;
    private List<Asignacion> listaAsignaciones;
    private List<Profesor> listaProfesores;
    private List<UnidadAprendizaje> listaUnidades;
    private Integer idProfesorSeleccionado;
    private Integer idUnidadSeleccionada;
    private String horaInicioStr;
    private String horaFinStr;

    public AsignacionBeanUI() {
        asignacionHelper = new AsignacionHelper();
        profesorHelper = new ProfesorHelper();
        unidadHelper = new UnidadAprendizajeHelper();
    }

    @PostConstruct
    public void init() {
        asignacion = new Asignacion();
        idProfesorSeleccionado = null;
        idUnidadSeleccionada = null;
        horaInicioStr = "";
        horaFinStr = "";
        cargarDatos();
    }

    public void cargarDatos() {
        listaAsignaciones = asignacionHelper.findAllAsignaciones();
        listaProfesores = profesorHelper.findAllProfesores();
        listaUnidades = unidadHelper.findAllUnidades();
    }

    public void guardar() {
        try {
            if (idProfesorSeleccionado == null || idUnidadSeleccionada == null) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN, "Atencion", "Debe seleccionar un profesor y una unidad."));
                return;
            }

            Profesor p = new Profesor();
            p.setId(idProfesorSeleccionado);
            asignacion.setProfesor(p);

            UnidadAprendizaje u = new UnidadAprendizaje();
            u.setId(idUnidadSeleccionada);
            asignacion.setUnidadAprendizaje(u);

            LocalTime inicio = parsearHora(horaInicioStr);
            LocalTime fin = parsearHora(horaFinStr);

            asignacion.setHoraInicio(inicio);
            asignacion.setHoraFin(fin);

            asignacionHelper.saveAsignacion(asignacion);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "Asignacion guardada exitosamente"));
            init();
        } catch (DateTimeParseException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Formato Invalido", "El formato de hora debe ser HH:mm"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
        }
    }

    private LocalTime parsearHora(String horaStr) throws DateTimeParseException {
        if (horaStr == null || horaStr.trim().isEmpty()) {
            throw new DateTimeParseException("Hora vacia", horaStr, 0);
        }
        String cadenaLimpia = horaStr.trim();
        try {
            DateTimeFormatter fmt24 = DateTimeFormatter.ofPattern("HH:mm");
            return LocalTime.parse(cadenaLimpia, fmt24);
        } catch (DateTimeParseException e) {
            DateTimeFormatter fmt12 = DateTimeFormatter.ofPattern("h:mm a", Locale.ENGLISH);
            return LocalTime.parse(cadenaLimpia.toLowerCase(), fmt12);
        }
    }

    public Asignacion getAsignacion() { return asignacion; }
    public void setAsignacion(Asignacion asignacion) { this.asignacion = asignacion; }

    public List<Asignacion> getListaAsignaciones() { return listaAsignaciones; }
    public void setListaAsignaciones(List<Asignacion> listaAsignaciones) { this.listaAsignaciones = listaAsignaciones; }

    public List<Profesor> getListaProfesores() { return listaProfesores; }
    public void setListaProfesores(List<Profesor> listaProfesores) { this.listaProfesores = listaProfesores; }

    public List<UnidadAprendizaje> getListaUnidades() { return listaUnidades; }
    public void setListaUnidades(List<UnidadAprendizaje> listaUnidades) { this.listaUnidades = listaUnidades; }

    public Integer getIdProfesorSeleccionado() { return idProfesorSeleccionado; }
    public void setIdProfesorSeleccionado(Integer idProfesorSeleccionado) { this.idProfesorSeleccionado = idProfesorSeleccionado; }

    public Integer getIdUnidadSeleccionada() { return idUnidadSeleccionada; }
    public void setIdUnidadSeleccionada(Integer idUnidadSeleccionada) { this.idUnidadSeleccionada = idUnidadSeleccionada; }

    public String getHoraInicioStr() { return horaInicioStr; }
    public void setHoraInicioStr(String horaInicioStr) { this.horaInicioStr = horaInicioStr; }

    public String getHoraFinStr() { return horaFinStr; }
    public void setHoraFinStr(String horaFinStr) { this.horaFinStr = horaFinStr; }
}