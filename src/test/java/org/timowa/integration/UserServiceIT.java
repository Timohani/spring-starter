package org.timowa.integration;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.timowa.annotation.IT;
import org.timowa.spring.database.repository.pool.ConnectionPool;
import org.timowa.spring.service.UserService;

@IT
@RequiredArgsConstructor
public class UserServiceIT {
    private final UserService userService;

    @MockitoBean(name = "connectionPool2")
    private ConnectionPool pool1;

    @Test
    void findById() {

    }
}
