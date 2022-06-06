package lt.viko.eif.api.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * This class is used to pass data to a request for creating a User object
 */
@Getter
@Setter
public class SignUpDto {
    @NotNull(message = "Username is required")
    @JsonProperty("username")
    private String username;

    @NotNull(message = "Password is required")
    @JsonProperty("password")
    private String password;
}
