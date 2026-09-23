package mx.desarrollo.facade;

import mx.desarrollo.delegate.DelegateAsignacion;
import mx.desarrollo.entity.Asignacion;
import java.util.List;

public class FacadeAsignacion {
    private final DelegateAsignacion delegateAsignacion;

    public FacadeAsignacion() {
        this.delegateAsignacion = new DelegateAsignacion();
    }

    public void saveAsignacion(Asignacion asignacion) throws Exception {
        delegateAsignacion.saveAsignacion(asignacion);
    }

    public List<Asignacion> findAllAsignaciones() {
        return delegateAsignacion.findAllAsignaciones();
    }
}