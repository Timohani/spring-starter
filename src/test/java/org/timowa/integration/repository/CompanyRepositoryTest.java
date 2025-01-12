package org.timowa.integration.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.timowa.annotation.IT;
import org.timowa.spring.database.entity.Company;
import org.timowa.spring.database.repository.CompanyRepository;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;

@IT
@RequiredArgsConstructor
public class CompanyRepositoryTest {

    private static final Integer APPLE_ID = 9;
    private final EntityManager entityManager;
    private final CompanyRepository companyRepository;

    @Test
    void delete() {
        var maybeCompany = companyRepository.findById(APPLE_ID);
        assertTrue(maybeCompany.isPresent());
        maybeCompany.ifPresent(companyRepository::delete);
        entityManager.flush();
        assertTrue(companyRepository.findById(APPLE_ID).isEmpty());
    }

    @Test
    void findById() {
        var company = entityManager.find(Company.class, 1);
        assertNotNull(company);
        assertThat(company.getLocales()).hasSize(2);
    }

    @Test
    void save() {
        var company = Company.builder()
                .name("Apple")
                .locales(Map.of("ru", "Apple описание",
                        "en", "Apple description"))
                .build();
        entityManager.persist(company);
        assertNotNull(company.getId());
    }
}
