package helper;

import mx.desarrollo.entity.UnidadAprendizaje;
import mx.desarrollo.integration.ServiceFacadeLocator;
import java.io.Serializable;
import java.util.List;

public class UnidadAprendizajeHelper implements Serializable {
    public void saveUnidad(UnidadAprendizaje unidad) throws Exception {
        ServiceFacadeLocator.getInstanceFacadeUnidadAprendizaje().saveUnidad(unidad);
    }

    public void updateUnidad(UnidadAprendizaje unidad) throws Exception {
        ServiceFacadeLocator.getInstanceFacadeUnidadAprendizaje().updateUnidad(unidad);
    }

    public void deleteUnidad(UnidadAprendizaje unidad) {
        ServiceFacadeLocator.getInstanceFacadeUnidadAprendizaje().deleteUnidad(unidad);
    }

    public List<UnidadAprendizaje> findAllUnidades() {
        return ServiceFacadeLocator.getInstanceFacadeUnidadAprendizaje().findAllUnidades();
    }
}