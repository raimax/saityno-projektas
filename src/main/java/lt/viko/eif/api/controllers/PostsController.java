package lt.viko.eif.api.controllers;


import lt.viko.eif.api.dtos.PostDto;
import lt.viko.eif.api.mapstruct.MapStructMapper;
import lt.viko.eif.api.mapstruct.MapStructMapperImpl;
import lt.viko.eif.api.models.Post;
import lt.viko.eif.api.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
@Validated
public class PostsController {

    @Autowired
    private PostRepository postRepository;

    private MapStructMapper mapper = new MapStructMapperImpl();

    @GetMapping
    public ResponseEntity<List<Post>> getPosts() {
        List<Post> posts = (List<Post>) postRepository.findAll();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addPost(@RequestBody @Valid PostDto postDto) {
        Post post = mapper.map(postDto);
        /**
         * TOTO: save image on server, then add image name to post.image
         */
        //postRepository.save(post);
        return new ResponseEntity<>("Post added successfully", HttpStatus.OK);
    }
}
