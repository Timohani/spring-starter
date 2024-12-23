package org.timowa.spring.database.repository.pool;

import lombok.ToString;

@ToString
public class ConnectionPool {
    private String username;
    private String password;
    private Integer poolSize;
    private String url;

    public ConnectionPool(String username, String password, Integer poolSize, String url) {
        this.username = username;
        this.password = password;
        this.poolSize = poolSize;
        this.url = url;
    }
}
