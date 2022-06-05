package lt.viko.eif.api.controllers;


import lt.viko.eif.api.dtos.PostDto;
import lt.viko.eif.api.models.Post;
import lt.viko.eif.api.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
@Validated
public class PostsController {
    private final PostService postService;

    @Autowired
    public PostsController(PostService postService) {
        this.postService = postService;
    }


    @GetMapping
    public ResponseEntity<List<Post>> getPosts() {
        return new ResponseEntity<>(postService.getAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getPost(@PathVariable Integer id) {
        try {
            Post post = postService.getById(id);
            return new ResponseEntity<>(post, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Post not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<String> addPost(@Valid @ModelAttribute PostDto postDto) {
        try {
            postService.add(postDto);
            return new ResponseEntity<>("Post added successfully", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Error adding post", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/random")
    public ResponseEntity<Post> getRandomPost() {
        return new ResponseEntity<>(postService.getRandom(), HttpStatus.OK);
    }

    @GetMapping("/top/views")
    public ResponseEntity<List<Post>> getPostsWithMostViews() {
        return new ResponseEntity<>(postService.getTopByViews(), HttpStatus.OK);
    }

    @GetMapping("/top/likes")
    public ResponseEntity<List<Post>> getPostsWithMostLikes() {
        return new ResponseEntity<>(postService.getTopByLikes(), HttpStatus.OK);
    }
}
