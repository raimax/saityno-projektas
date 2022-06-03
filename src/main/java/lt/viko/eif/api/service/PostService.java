package lt.viko.eif.api.service;

import lt.viko.eif.api.dtos.PostDto;
import lt.viko.eif.api.models.Post;

import java.io.IOException;
import java.util.List;

public interface PostService {
    Post getById(Integer id);
    List<Post> getAll();
    void add(PostDto post) throws IOException;
    Post getRandom();
}
