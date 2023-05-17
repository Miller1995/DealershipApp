package md.miller1995.Dealership.models.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class UserAuthDTO implements Serializable {
    @NotBlank(message = "Username can't be empty")
    private String username;
    @NotBlank(message = "Date can't be null and format should be yyyy-MM-dd")
    private LocalDate dateOfBirth;
    @NotBlank(message = "Password can't be empty")
    private String userPassword;
}
