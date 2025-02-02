package org.timowa.spring.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.timowa.spring.database.entity.Company;
import org.timowa.spring.database.entity.User;
import org.timowa.spring.database.repository.CompanyRepository;
import org.timowa.spring.dto.UserCreatedEditDto;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserCreateEditMapper implements Mapper<UserCreatedEditDto, User> {
    private final CompanyRepository companyRepository;

    @Override
    public User map(UserCreatedEditDto fromObject, User toObject) {
        copy(fromObject, toObject);
        return toObject;
    }

    @Override
    public User map(UserCreatedEditDto object) {
        User user = new User();
        copy(object, user);
        return user;
    }

    private void copy(UserCreatedEditDto object, User user) {
        user.setUsername(object.getUsername());
        user.setFirstname(object.getFirstname());
        user.setLastname(object.getLastname());
        user.setBirthDate(object.getBirthDate());
        user.setRole(object.getRole());
        user.setCompany(getCompany(object.getCompanyId()));
    }

    private Company getCompany(Integer companyId) {
        return Optional.ofNullable(companyId)
                .flatMap(companyRepository::findById)
                .orElse(null);
    }
}
