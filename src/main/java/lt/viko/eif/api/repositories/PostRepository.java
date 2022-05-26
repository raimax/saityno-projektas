package lt.viko.eif.api.repositories;

import lt.viko.eif.api.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Integer> {
}
