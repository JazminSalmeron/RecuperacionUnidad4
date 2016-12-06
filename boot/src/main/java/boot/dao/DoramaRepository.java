package boot.dao;

import org.springframework.data.repository.CrudRepository;

import boot.model.Dorama;
import boot.model.Student;

public interface DoramaRepository extends CrudRepository<Dorama,Integer>{

}
