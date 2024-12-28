package org.timowa.spring;

import lombok.Cleanup;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.timowa.spring.config.ApplicationConfiguration;
import org.timowa.spring.service.CompanyService;

public class SpringRunner {
    public static void main(String[] args) {
        @Cleanup var context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        var companyService = context.getBean(CompanyService.class);
        System.out.println(companyService.findById(1));
    }
}
