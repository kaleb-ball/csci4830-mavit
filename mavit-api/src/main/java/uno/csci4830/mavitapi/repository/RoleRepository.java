
package uno.csci4830.mavitapi.repository;

import org.springframework.data.repository.CrudRepository;
import uno.csci4830.mavitapi.model.UserRole;

public interface RoleRepository extends CrudRepository<UserRole, Integer> {

