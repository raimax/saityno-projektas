package lt.viko.eif.api.repositories;

import lt.viko.eif.api.models.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Integer> {
    @Query(value = "SELECT * FROM post ORDER BY rand() LIMIT 1", nativeQuery = true)
    Post getRandom();
    List<Post> findTop3ByOrderByViewsDesc();
}