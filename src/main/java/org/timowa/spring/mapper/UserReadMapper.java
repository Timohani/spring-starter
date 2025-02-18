package org.timowa.spring.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.timowa.spring.database.entity.User;
import org.timowa.spring.dto.CompanyReadDto;
import org.timowa.spring.dto.UserReadDto;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserReadMapper implements Mapper<User, UserReadDto> {

    private final CompanyReadMapper companyReadMapper;

    @Override
    public UserReadDto map(User object) {
        CompanyReadDto company = Optional.ofNullable(object.getCompany())
                .map(companyReadMapper::map)
                .orElse(null);
        return new UserReadDto(
                object.getId(),
                object.getUsername(),
                object.getBirthDate(),
                object.getFirstname(),
                object.getLastname(),
                object.getRole(),
                object.getImage(),
                company
        );
    }
}
