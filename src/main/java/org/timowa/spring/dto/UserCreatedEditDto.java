package org.timowa.spring.dto;

import lombok.Value;
import lombok.experimental.FieldNameConstants;
import org.timowa.spring.database.entity.Role;

import java.time.LocalDate;

@Value
@FieldNameConstants
public class UserCreatedEditDto {
    String username;
    LocalDate birthDate;
    String firstname;
    String lastname;
    Role role;
    Integer companyId;
}
