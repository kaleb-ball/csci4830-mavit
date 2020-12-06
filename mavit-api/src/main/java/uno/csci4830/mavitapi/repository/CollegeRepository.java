package uno.csci4830.mavitapi.repository;

import org.springframework.data.repository.CrudRepository;
import uno.csci4830.mavitapi.model.College;
import uno.csci4830.mavitapi.model.Page;

import java.util.List;

public interface CollegeRepository extends CrudRepository<College, Integer> {

    College getCollegeByCode(String code);

    College findFirstByPage(Page page);

}
