package lt.viko.eif.api.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class RegisterDto extends LoginDto {
    @NotNull(message = "Password repeat is required")
    @JsonProperty("repeatPassword")
    private String repeatPassword;
}
