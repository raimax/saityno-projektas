package lt.viko.eif.api.repositories;

import lt.viko.eif.api.models.Like;
import org.springframework.data.repository.CrudRepository;

public interface LikesRepository extends CrudRepository<Like, Integer> {
    Like findByUserIdAndPostId(Integer userId, Integer postId);
}
