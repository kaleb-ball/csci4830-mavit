package uno.csci4830.mavitapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uno.csci4830.mavitapi.model.Page;

@Repository
public interface PageRepository extends CrudRepository<Page, Integer> {
}
