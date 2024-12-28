package org.timowa.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.timowa.spring.config.ApplicationConfiguration;
import org.timowa.spring.database.repository.UserRepository;

public class SpringRunner {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        var userRepository = context.getBean(UserRepository.class);

        System.out.println(userRepository);
    }
}
