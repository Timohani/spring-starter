package org.timowa.spring.service;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.timowa.spring.database.repository.UserRepository;
import org.timowa.spring.mapper.UserMapper;

@RequiredArgsConstructor
@ToString
public class UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;
}
