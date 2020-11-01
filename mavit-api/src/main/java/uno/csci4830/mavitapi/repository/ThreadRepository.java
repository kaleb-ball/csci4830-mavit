package uno.csci4830.mavitapi.repository;

import org.springframework.data.repository.CrudRepository;
import uno.csci4830.mavitapi.model.Thread;

import java.util.List;

public interface ThreadRepository extends CrudRepository<Thread, Integer> {

    List<Thread> findAllByEnabled(Boolean enabled);


}
