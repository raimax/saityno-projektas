package lt.viko.eif.api.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class LoginDto {
    @NotNull(message = "Username is required")
    @Max(message = "Username must be less than 20 characters long", value = 20)
    @JsonProperty("username")
    private String username;

    @NotNull(message = "Password is required")
    @JsonProperty("password")
    private String password;
}
