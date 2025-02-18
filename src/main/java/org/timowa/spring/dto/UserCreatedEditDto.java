package org.timowa.spring.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Value;
import lombok.experimental.FieldNameConstants;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;
import org.timowa.spring.database.entity.Role;
import org.timowa.spring.validator.UserInfo;

import java.time.LocalDate;

@Value
@FieldNameConstants
@UserInfo
public class UserCreatedEditDto {
    @Email
    String username;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    LocalDate birthDate;

    @Size(min = 3, max = 30)
    String firstname;

    String lastname;

    Role role;

    Integer companyId;

    MultipartFile image;
}
