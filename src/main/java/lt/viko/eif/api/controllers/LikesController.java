package lt.viko.eif.api.controllers;

import lt.viko.eif.api.dtos.LikeDto;
import lt.viko.eif.api.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * This class is an endpoint for adding likes
 */
@RestController
@RequestMapping("/api/likes")
@Validated
public class LikesController {

    @Autowired
    private LikeService likeService;

    /**
     * This method adds a like
     *
     * @param likeDto data transfer object of the like parameter
     * @return response message with status
     */
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
