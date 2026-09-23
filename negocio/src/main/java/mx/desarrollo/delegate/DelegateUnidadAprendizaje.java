package mx.desarrollo.delegate;

import mx.desarrollo.entity.UnidadAprendizaje;
import mx.desarrollo.persistence.integration.ServiceLocator;
import java.util.List;

public class DelegateUnidadAprendizaje {
    public void saveUnidad(UnidadAprendizaje unidad) throws Exception {
        validarHoras(unidad);
        ServiceLocator.getInstanceUnidadAprendizajeDAO().save(unidad);
    }

    public void updateUnidad(UnidadAprendizaje unidad) throws Exception {
        validarHoras(unidad);
        ServiceLocator.getInstanceUnidadAprendizajeDAO().update(unidad);
    }

    public void deleteUnidad(UnidadAprendizaje unidad) {
        ServiceLocator.getInstanceUnidadAprendizajeDAO().delete(unidad);
    }

    public List<UnidadAprendizaje> findAllUnidades() {
        return ServiceLocator.getInstanceUnidadAprendizajeDAO().obtenerTodos();
    }

    private void validarHoras(UnidadAprendizaje unidad) throws Exception {
        if (unidad.getHorasClase() < 0 || unidad.getHorasClase() > 4 ||
                unidad.getHorasTaller() < 0 || unidad.getHorasTaller() > 4 ||
                unidad.getHorasLaboratorio() < 0 || unidad.getHorasLaboratorio() > 4) {
            throw new Exception("Las horas de clase, taller y laboratorio deben ser maximo 4");
        }
    }
}