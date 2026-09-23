package helper;

import mx.desarrollo.entity.Profesor;
import mx.desarrollo.integration.ServiceFacadeLocator;
import java.io.Serializable;
import java.util.List;

public class ProfesorHelper implements Serializable {
    public void saveProfesor(Profesor profesor) throws Exception {
        ServiceFacadeLocator.getInstanceFacadeProfesor().saveProfesor(profesor);
    }

    public List<Profesor> findAllProfesores() {
        return ServiceFacadeLocator.getInstanceFacadeProfesor().findAllProfesores();
    }
}