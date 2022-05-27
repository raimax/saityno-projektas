package lt.viko.eif.api.controllers;


import lt.viko.eif.api.dtos.PostDto;
import lt.viko.eif.api.iservice.IFileService;
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
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
@Validated
public class PostsController {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private IFileService fileService;

    private MapStructMapper mapper = new MapStructMapperImpl();

    @GetMapping
    public ResponseEntity<List<Post>> getPosts() {
        List<Post> posts = (List<Post>) postRepository.findAll();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addPost(@Valid @ModelAttribute PostDto postDto) {
        Post post = mapper.map(postDto);

        try {
            String imageName = fileService.SaveFile("images/unoptimized", postDto.getImageFile());
            post.setImage(imageName);
            post.getUser().setId(postDto.getUserId());
            postRepository.save(post);

            return new ResponseEntity<>("Post added successfully", HttpStatus.OK);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Error adding post", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
