package org.timowa.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.timowa.spring.database.repository.UserRepository;

public class SpringRunner {
    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("application.xml");

        var userRepository = context.getBean("repo1", UserRepository.class);

        System.out.println(userRepository);
    }
}
