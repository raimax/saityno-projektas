package lt.viko.eif.api.controllers;

import lt.viko.eif.api.dtos.LikeDto;
import lt.viko.eif.api.mapstruct.MapStructMapper;
import lt.viko.eif.api.mapstruct.MapStructMapperImpl;
import lt.viko.eif.api.models.Like;
import lt.viko.eif.api.repositories.LikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/likes")
public class LikesController {

    @Autowired
    private LikesRepository likesRepository;

    @PostMapping
    public ResponseEntity<String> addLike(LikeDto likeDto) {
        Like like = new Like();
        like.getUser().setId(likeDto.getUserId());
        like.getPost().setId(likeDto.getPostId());
        likesRepository.save(like);
        return new ResponseEntity<>("Post liked successfully", HttpStatus.CREATED);
    }
}
