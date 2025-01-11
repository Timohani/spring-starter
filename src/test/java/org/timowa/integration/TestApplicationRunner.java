package org.timowa.integration;

import org.springframework.boot.test.context.TestConfiguration;
import org.timowa.spring.database.repository.pool.ConnectionPool;

@TestConfiguration
public class TestApplicationRunner {

    private ConnectionPool connectionPool;
}
