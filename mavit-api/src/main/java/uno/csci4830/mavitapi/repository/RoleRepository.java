
package uno.csci4830.mavitapi.repository;

import org.springframework.data.repository.CrudRepository;
import uno.csci4830.mavitapi.enums.UserRoleEnum;
import uno.csci4830.mavitapi.model.Role;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Integer> {
    Optional<Role> findByName(UserRoleEnum name);
}