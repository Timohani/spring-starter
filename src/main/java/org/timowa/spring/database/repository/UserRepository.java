package org.timowa.spring.database.repository;

import lombok.ToString;
import org.springframework.stereotype.Repository;
import org.timowa.spring.database.repository.pool.ConnectionPool;

import java.util.List;

@ToString
public class UserRepository {

    private final ConnectionPool connectionPool1;
    private Integer poolSize;
    private List<ConnectionPool> connectionPool;

    public UserRepository(ConnectionPool connectionPool1) {
        this.connectionPool1 = connectionPool1;
    }
}
