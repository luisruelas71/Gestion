package mx.desarrollo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "unidades_aprendizaje")
public class UnidadAprendizaje implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_unidad_aprendizaje", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "nombre_unidad", nullable = false, length = 50)
    private String nombreUnidad;

    @NotNull
    @Column(name = "horas_clase", nullable = false)
    private Integer horasClase;

    @NotNull
    @Column(name = "horas_taller", nullable = false)
    private Integer horasTaller;

    @NotNull
    @Column(name = "horas_laboratorio", nullable = false)
    private Integer horasLaboratorio;

    @OneToMany(mappedBy = "unidadAprendizaje")
    private Set<Asignacion> asignaciones = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreUnidad() {
        return nombreUnidad;
    }

    public void setNombreUnidad(String nombreUnidad) {
        this.nombreUnidad = nombreUnidad;
    }

    public Integer getHorasClase() {
        return horasClase;
    }

    public void setHorasClase(Integer horasClase) {
        this.horasClase = horasClase;
    }

    public Integer getHorasTaller() {
        return horasTaller;
    }

    public void setHorasTaller(Integer horasTaller) {
        this.horasTaller = horasTaller;
    }

    public Integer getHorasLaboratorio() {
        return horasLaboratorio;
    }

    public void setHorasLaboratorio(Integer horasLaboratorio) {
        this.horasLaboratorio = horasLaboratorio;
    }

    public Set<Asignacion> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(Set<Asignacion> asignaciones) {
        this.asignaciones = asignaciones;
    }
}