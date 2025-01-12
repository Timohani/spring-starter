package org.timowa.spring.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.timowa.spring.database.entity.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

    Optional<Company> findByName(String name);

    List<Company> findAllByNameContainingIgnoreCase(String fragment);

}
