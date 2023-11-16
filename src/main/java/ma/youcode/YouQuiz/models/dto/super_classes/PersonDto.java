package ma.youcode.YouQuiz.models.dto.super_classes;

import java.time.LocalDate;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public abstract class PersonDto {
    
    @NotEmpty(message = "first name is required.")
    @Size(max = 50, message = "first name must be less than 50 character.")
    protected String firstName;

    @NotEmpty(message = "last name is required.")
    @Size(max = 50, message = "last name must be less than 50 character.")
    protected String lastName;

    @NotNull
    protected LocalDate birthDate;

    @NotEmpty(message = "address is required.")
    protected String address;

}
