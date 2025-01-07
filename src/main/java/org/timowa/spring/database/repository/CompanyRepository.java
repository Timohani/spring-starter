package org.timowa.spring.database.repository;

import org.springframework.stereotype.Repository;
import org.timowa.spring.database.entity.Company;

import java.util.Collections;
import java.util.Optional;

@Repository
public class CompanyRepository {

    public Optional<Company> findById(Integer id) {
        System.out.println("CompanyRepository findById method");
        return Optional.of(new Company(id, null, Collections.emptyMap()));
    }
}
