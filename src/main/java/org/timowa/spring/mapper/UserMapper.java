package org.timowa.spring.mapper;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.timowa.spring.dto.UserDto;

@Component
@ToString
public class UserMapper {
    @Autowired
    private UserDto userDto;
}
