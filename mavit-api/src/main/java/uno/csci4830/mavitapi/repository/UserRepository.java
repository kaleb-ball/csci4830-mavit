package uno.csci4830.mavitapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uno.csci4830.mavitapi.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
