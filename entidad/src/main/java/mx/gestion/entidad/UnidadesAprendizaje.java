package mx.gestion.entidad;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "unidades_aprendizaje")
public class UnidadesAprendizaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_unidad_aprendizaje", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "nombre_unidad", nullable = false, length = 50)
    private String nombreUnidad;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "horas_clase", nullable = false)
    private Byte horasClase;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "horas_taller", nullable = false)
    private Byte horasTaller;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "horas_laboratorio", nullable = false)
    private Byte horasLaboratorio;

    @OneToMany(mappedBy = "idUnidadAprendizaje")
    private Set<Asignacione> asignaciones = new LinkedHashSet<>();

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

    public Byte getHorasClase() {
        return horasClase;
    }

    public void setHorasClase(Byte horasClase) {
        this.horasClase = horasClase;
    }

    public Byte getHorasTaller() {
        return horasTaller;
    }

    public void setHorasTaller(Byte horasTaller) {
        this.horasTaller = horasTaller;
    }

    public Byte getHorasLaboratorio() {
        return horasLaboratorio;
    }

    public void setHorasLaboratorio(Byte horasLaboratorio) {
        this.horasLaboratorio = horasLaboratorio;
    }

    public Set<Asignacione> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(Set<Asignacione> asignaciones) {
        this.asignaciones = asignaciones;
    }

}