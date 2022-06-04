package lt.viko.eif.api.controllers;

import lt.viko.eif.api.dtos.LikeDto;
import lt.viko.eif.api.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/likes")
@Validated
public class LikesController {

    @Autowired
    private LikeService likeService;

    @Secured({"USER" , "ADMIN"})
    @PostMapping
    public ResponseEntity<String> addLike(@RequestBody @Valid LikeDto likeDto) {
        if (!likeService.userLikedAlready(likeDto.getUserId(), likeDto.getPostId())) {
            likeService.add(likeDto);
            return new ResponseEntity<>("Post liked successfully", HttpStatus.OK);
        }

        likeService.remove(likeDto);
        return new ResponseEntity<>("Post unliked", HttpStatus.OK);
    }
}
