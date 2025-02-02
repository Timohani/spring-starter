package org.timowa.integration.service;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.timowa.annotation.IT;
import org.timowa.spring.config.DatabaseProperties;
import org.timowa.spring.dto.CompanyReadDto;
import org.timowa.spring.service.CompanyService;


@IT
@RequiredArgsConstructor
//@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class CompanyServiceIT {
    private static final Integer COMPANY_ID = 1;


    private final CompanyService companyService;
    private final DatabaseProperties databaseProperties;


    @Test
    void findById() {
        var actualResult = companyService.findById(COMPANY_ID);

        Assertions.assertTrue(actualResult.isPresent());

        var expectedResult = new CompanyReadDto(COMPANY_ID, null);

        actualResult.ifPresent(actual -> Assertions.assertEquals(expectedResult, actual));
    }
}