package uno.csci4830.mavitapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uno.csci4830.mavitapi.model.Page;
import uno.csci4830.mavitapi.model.University;
import java.util.Set;

@Repository
public interface UniversityRepository extends CrudRepository<University, Integer> {

    University findFirstByPage(Page page);

    University findFirstByCode(String code);

}
