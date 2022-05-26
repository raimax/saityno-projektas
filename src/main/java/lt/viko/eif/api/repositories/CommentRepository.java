package lt.viko.eif.api.repositories;

import lt.viko.eif.api.models.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository  extends CrudRepository<Comment, Integer> {
}
