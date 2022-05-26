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

    private MapStructMapper mapper = new MapStructMapperImpl();

    @PostMapping
    public ResponseEntity<Like> addLike(LikeDto likeDto) {
        Like like = mapper.map(likeDto);
        like.getUser().setId(likeDto.getUserId());
        like.getPost().setId(likeDto.getPostId());
        likesRepository.save(like);
        return new ResponseEntity<>(like, HttpStatus.CREATED);
    }
}
