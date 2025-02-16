package org.timowa.spring.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;
import lombok.experimental.FieldNameConstants;
import org.springframework.format.annotation.DateTimeFormat;
import org.timowa.spring.database.entity.Role;

import java.time.LocalDate;

@Value
@FieldNameConstants
public class UserCreatedEditDto {
    @Email
    String username;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    LocalDate birthDate;

    @NotBlank
    @Size(min = 3, max = 30)
    String firstname;

    @NotNull
    String lastname;

    Role role;

    Integer companyId;
}
