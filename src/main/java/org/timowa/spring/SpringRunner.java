package org.timowa.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.timowa.spring.database.repository.UserRepository;
import org.timowa.spring.service.UserService;

public class SpringRunner {
    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("application.xml");

        var userService = context.getBean("userService", UserService.class);

        System.out.println(userService);
    }
}
