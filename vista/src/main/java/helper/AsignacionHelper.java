package helper;

import mx.desarrollo.entity.Asignacion;
import mx.desarrollo.integration.ServiceFacadeLocator;
import java.io.Serializable;
import java.util.List;

public class AsignacionHelper implements Serializable {
    public void saveAsignacion(Asignacion asignacion) throws Exception {
        ServiceFacadeLocator.getInstanceFacadeAsignacion().saveAsignacion(asignacion);
    }

    public List<Asignacion> findAllAsignaciones() {
        return ServiceFacadeLocator.getInstanceFacadeAsignacion().findAllAsignaciones();
    }
}