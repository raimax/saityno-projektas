package lt.viko.eif.api.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class PostDto {

    @NotNull(message = "Title is required")
    @Size(min = 1, max = 100, message = "Title should be between 1 and 100 characters long")
    private String title;
    @NotNull(message = "Image is required")
    private MultipartFile imageFile;
    @NotNull(message = "User id is required")
    private Integer userId;
}
