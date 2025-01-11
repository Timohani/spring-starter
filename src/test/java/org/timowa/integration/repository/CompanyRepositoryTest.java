package org.timowa.integration.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.timowa.annotation.IT;
import org.timowa.spring.database.entity.Company;
import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;

@IT
@RequiredArgsConstructor
public class CompanyRepositoryTest {

    private final EntityManager entityManager;

    @Test
    void findById() {
        var company = entityManager.find(Company.class, 1);
        assertNotNull(company);
        assertThat(company.getLocales()).hasSize(2);
    }
}
