package lt.viko.eif.api.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class LoginDto {
    @NotNull(message = "Username is required")
    @Size(min = 1, max = 32, message = "Username must be between 1 and 32 characters long")
    @JsonProperty("username")
    private String username;

    @NotNull(message = "Password is required")
    @JsonProperty("password")
    private String password;
}
