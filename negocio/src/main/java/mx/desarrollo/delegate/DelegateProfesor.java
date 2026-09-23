package mx.desarrollo.delegate;

import mx.desarrollo.entity.Profesor;
import mx.desarrollo.persistence.integration.ServiceLocator;
import java.util.List;
import java.util.regex.Pattern;

public class DelegateProfesor {
    public void saveProfesor(Profesor profesor) throws Exception {
        String regex = "^[A-Z&]{3,4}[0-9]{6}[A-Z0-9]{3}$";
        if (!Pattern.matches(regex, profesor.getRfc())) {
            throw new Exception("El formato del RFC es invalido");
        }
        ServiceLocator.getInstanceProfesorDAO().save(profesor);
    }

    public List<Profesor> findAllProfesores() {
        return ServiceLocator.getInstanceProfesorDAO().obtenerTodos();
    }
}