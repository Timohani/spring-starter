package org.timowa.spring.database.repository;

import lombok.ToString;
import org.timowa.spring.bpp.InjectBean;
import org.timowa.spring.database.repository.pool.ConnectionPool;

@ToString
public class UserRepository {

    @InjectBean
    private ConnectionPool connectionPool;
}
