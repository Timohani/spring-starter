package org.timowa.spring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "db")
public record DatabaseProperties(String username,
                                 String password,
                                 String driver,
                                 String url,
                                 String hosts,
                                 PoolProperties pool,
                                 List<PoolProperties> pools
) {

    private record PoolProperties(Integer size,
                                  Integer timeout) {
    }
}
