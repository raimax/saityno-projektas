package lt.viko.eif.api.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class LikeDto {
    @NotNull(message = "User id is not provided")
    @JsonProperty("userId")
    private Integer userId;

    @NotNull(message = "Post id is not provided")
    @JsonProperty("postId")
    private Integer postId;
}
