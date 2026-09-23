package mx.desarrollo.delegate;

import mx.desarrollo.entity.Asignacion;
import mx.desarrollo.persistence.integration.ServiceLocator;
import java.util.List;

public class DelegateAsignacion {
    public void saveAsignacion(Asignacion asignacion) throws Exception {
        if (asignacion.getHoraFin().isBefore(asignacion.getHoraInicio()) ||
                asignacion.getHoraFin().equals(asignacion.getHoraInicio())) {
            throw new Exception("La hora de fin debe ser posterior a la hora de inicio");
        }

        boolean traslape = ServiceLocator.getInstanceAsignacionDAO().existeTraslape(
                asignacion.getProfesor().getId(),
                asignacion.getDiaSemana(),
                asignacion.getHoraInicio(),
                asignacion.getHoraFin()
        );

        if (traslape) {
            throw new Exception("Existe un traslape de horario para el profesor en ese dia");
        }

        ServiceLocator.getInstanceAsignacionDAO().save(asignacion);
    }

    public List<Asignacion> findAllAsignaciones() {
        return ServiceLocator.getInstanceAsignacionDAO().obtenerTodos();
    }
}