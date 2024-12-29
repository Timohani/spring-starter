package org.timowa.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.core.SpringProperties;
import org.timowa.spring.config.DatabaseProperties;

@SpringBootApplication
@ConfigurationPropertiesScan
public class ApplicationRunner {
    public static void main(String[] args) {
        var context = SpringApplication.run(ApplicationRunner.class, args);
        var test = SpringProperties.getProperty("test.msg");
        System.out.println(test);

        System.out.println(context.getBean(DatabaseProperties.class));
    }
}
