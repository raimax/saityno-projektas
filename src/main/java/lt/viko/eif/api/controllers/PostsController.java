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

/**
 * This class is an endpoint for accessing and adding posts
 */
@RestController
@RequestMapping("/api/posts")
@Validated
public class PostsController {
    private final PostService postService;

    /**
     * Injecting instance of PostService
     *
     * @param postService interface of PostService
     */
    @Autowired
    public PostsController(PostService postService) {
        this.postService = postService;
    }

    /**
     * This method retrieves all posts
     *
     * @return Post list with status, or only status with message if not found
     */
    @GetMapping
    public ResponseEntity<List<Post>> getPosts() {
        return new ResponseEntity<>(postService.getAll(), HttpStatus.OK);
    }

    /**
     * This method retrieves Post specified by ID
     *
     * @param id ID of the post
     * @return post with status, or only status with message if not found
     */
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

    /**
     * This method adds a post
     *
     * @param postDto data transfer object of the post parameter
     * @return response message with status
     */
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

    /**
     * This method retrieves random post
     *
     * @return random post with status
     */
    @GetMapping("/random")
    public ResponseEntity<Post> getRandomPost() {
        return new ResponseEntity<>(postService.getRandom(), HttpStatus.OK);
    }

    /**
     * This method retrieves top viewed posts
     *
     * @return top viewed posts with status
     */
    @GetMapping("/top/views")
    public ResponseEntity<List<Post>> getPostsWithMostViews() {
        return new ResponseEntity<>(postService.getTopByViews(), HttpStatus.OK);
    }

    /**
     * This method retrieves top liked posts
     *
     * @return top liked posts with status
     */
    @GetMapping("/top/likes")
    public ResponseEntity<List<Post>> getPostsWithMostLikes() {
        return new ResponseEntity<>(postService.getTopByLikes(), HttpStatus.OK);
    }
}
