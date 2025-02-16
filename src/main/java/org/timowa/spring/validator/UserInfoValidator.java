package org.timowa.spring.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;
import org.timowa.spring.dto.UserCreatedEditDto;

import static org.springframework.util.StringUtils.hasText;

@Component
public class UserInfoValidator implements ConstraintValidator<UserInfo, UserCreatedEditDto> {

    @Override
    public boolean isValid(UserCreatedEditDto value, ConstraintValidatorContext constraintValidatorContext) {
        return hasText(value.getFirstname()) || hasText(value.getLastname());
    }
}
