package lt.viko.eif.api.controllers;

import lt.viko.eif.api.dtos.CommentDto;
import lt.viko.eif.api.mapstruct.MapStructMapper;
import lt.viko.eif.api.models.Comment;
import lt.viko.eif.api.service.CommentService;
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
@RequestMapping("/api/comments")
@Validated
public class CommentsController {

    private CommentService commentService;
    private MapStructMapper mapper;

    @Autowired
    public CommentsController(CommentService commentService, MapStructMapper mapper) {
        this.commentService = commentService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<String> addComment(@RequestBody @Valid CommentDto commentDto) {
        Comment comment = mapper.map(commentDto);
        commentService.add(comment);

        return new ResponseEntity<>("Comment added successfully", HttpStatus.OK);
    }
}
