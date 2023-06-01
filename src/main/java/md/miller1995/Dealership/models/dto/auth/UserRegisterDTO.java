package md.miller1995.Dealership.models.dto.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterDTO implements Serializable {

    @NotBlank(message = "Username can't be empty")
    private String username;
    @NotBlank(message = "Date can't be null and format should be yyyy-MM-dd")
    private LocalDate dateOfBirth;
    @NotBlank(message = "Email can't be empty")
    private String email;
    @NotBlank(message = "Password can't be empty")
    private String userPassword;
}
