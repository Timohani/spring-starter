package org.timowa.spring.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.timowa.spring.database.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
