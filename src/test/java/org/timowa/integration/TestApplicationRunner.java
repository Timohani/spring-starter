package org.timowa.integration;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.timowa.spring.database.repository.pool.ConnectionPool;

@TestConfiguration
public class TestApplicationRunner {

    @MockitoBean(name = "connectionPool2")
    private ConnectionPool pool1;
}
