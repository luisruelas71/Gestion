package mx.desarrollo.facade;

import mx.desarrollo.delegate.DelegateUnidadAprendizaje;
import mx.desarrollo.entity.UnidadAprendizaje;
import java.util.List;

public class FacadeUnidadAprendizaje {
    private final DelegateUnidadAprendizaje delegateUnidad;

    public FacadeUnidadAprendizaje() {
        this.delegateUnidad = new DelegateUnidadAprendizaje();
    }

    public void saveUnidad(UnidadAprendizaje unidad) throws Exception {
        delegateUnidad.saveUnidad(unidad);
    }

    public void updateUnidad(UnidadAprendizaje unidad) throws Exception {
        delegateUnidad.updateUnidad(unidad);
    }

    public void deleteUnidad(UnidadAprendizaje unidad) {
        delegateUnidad.deleteUnidad(unidad);
    }

    public List<UnidadAprendizaje> findAllUnidades() {
        return delegateUnidad.findAllUnidades();
    }
}