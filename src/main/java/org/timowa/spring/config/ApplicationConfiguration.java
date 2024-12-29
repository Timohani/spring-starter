package org.timowa.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.timowa.spring.database.repository.UserRepository;
import org.timowa.spring.database.repository.pool.ConnectionPool;

@Configuration
@PropertySource("classpath:application.yml")
@ComponentScan("org.timowa.spring")
public class ApplicationConfiguration {

    @Bean("connectionPool1")
    public ConnectionPool connectionPool(@Value("${db.username}") String username) {
        return new ConnectionPool(username, "123", 100, "---");
    }

    @Bean
    public ConnectionPool connectionPool2() {
        return new ConnectionPool("postgres", "root", 20, "url");
    }

    @Bean
    public UserRepository userRepository1() {
        return new UserRepository(connectionPool2());
    }
}
