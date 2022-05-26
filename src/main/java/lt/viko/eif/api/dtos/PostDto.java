package lt.viko.eif.api.dtos;

import lombok.Getter;
import lombok.Setter;
import lt.viko.eif.api.models.User;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PostDto {

    @NotNull(message = "Title is required")
    private String title;
    @NotNull(message = "Image is required")
    private String image;
    @NotNull(message = "User is required")
    private User user;
}
