package uno.csci4830.mavitapi.repository;

import org.springframework.data.repository.CrudRepository;
import uno.csci4830.mavitapi.model.Comment;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Integer> {

    List<Comment> findAllByEnabled(Boolean enabled);

}
