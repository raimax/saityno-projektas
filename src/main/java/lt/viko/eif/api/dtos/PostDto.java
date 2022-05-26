package lt.viko.eif.api.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class PostDto {

    @Size(min = 1, max = 100, message = "Title should be between 1 and 100 characters")
    private String title;
    @NotNull(message = "Image is required")
    private String image;
}
