package mx.desarrollo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "profesores")
public class Profesor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesor", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Size(max = 50)
    @NotNull
    @Column(name = "apellido_paterno", nullable = false, length = 50)
    private String apellidoPaterno;

    @Size(max = 50)
    @NotNull
    @Column(name = "apellido_materno", nullable = false, length = 50)
    private String apellidoMaterno;

    @Size(max = 13)
    @NotNull
    @Column(name = "rfc", nullable = false, length = 13)
    private String rfc;

    @OneToMany(mappedBy = "profesor")
    private Set<Asignacion> asignaciones = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public Set<Asignacion> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(Set<Asignacion> asignaciones) {
        this.asignaciones = asignaciones;
    }
}