package org.timowa.spring.mapper;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.timowa.spring.dto.UserDto;

@RequiredArgsConstructor
@ToString
public class UserMapper {
    private final UserDto userDto;
}
