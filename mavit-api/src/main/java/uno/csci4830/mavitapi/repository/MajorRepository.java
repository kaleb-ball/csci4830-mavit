package uno.csci4830.mavitapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uno.csci4830.mavitapi.model.Major;
import uno.csci4830.mavitapi.model.Page;

import java.util.List;


@Repository
public interface MajorRepository extends CrudRepository<Major, Integer> {

    Major findFirstByPage(Page page);

    List<Major> getMajorsByCollegeCode(String collegeCode);

}
