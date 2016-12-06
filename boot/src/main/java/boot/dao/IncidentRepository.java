package boot.dao;

import org.springframework.data.repository.CrudRepository;

import boot.model.Incident;
import boot.model.Student;

public interface IncidentRepository extends CrudRepository<Incident,Integer>{

}
