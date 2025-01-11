package org.timowa.integration.service;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.timowa.annotation.IT;
import org.timowa.spring.database.repository.pool.ConnectionPool;
import org.timowa.spring.service.UserService;

@IT
@RequiredArgsConstructor
class UserServiceIT {
    private final UserService userService;

    @Test
    void findById() {

    }
}
