package uno.csci4830.mavitapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uno.csci4830.mavitapi.enums.PageTypeEnum;
import uno.csci4830.mavitapi.model.PageType;

import java.util.Optional;

@Repository
public interface PageTypeRepository extends CrudRepository<PageType, Integer> {

    Optional<PageType> findByName(PageTypeEnum pageTypeEnum);
}
