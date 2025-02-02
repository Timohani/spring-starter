package org.timowa.spring.mapper;

import org.springframework.stereotype.Component;
import org.timowa.spring.database.entity.Company;
import org.timowa.spring.dto.CompanyReadDto;

@Component
public class CompanyReadMapper implements Mapper<Company, CompanyReadDto> {

    @Override
    public CompanyReadDto map(Company object) {
        return new CompanyReadDto(
                object.getId(),
                object.getName()
        );
    }
}
