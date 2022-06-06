package lt.viko.eif.api.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lt.viko.eif.api.models.Post;
import lt.viko.eif.api.models.User;

import javax.validation.constraints.NotNull;

/**
 * This class is used to pass data to a request for creating a Comment object
 */
@Getter
@Setter
public class CommentDto {
    @JsonProperty("content")
    private String content;

    @NotNull(message = "user is not provided")
    @JsonProperty("user")
    private User user;

    @NotNull(message = "post is not provided")
    @JsonProperty("post")
    private Post post;
}
