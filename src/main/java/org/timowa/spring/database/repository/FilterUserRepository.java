package org.timowa.spring.database.repository;

import org.timowa.spring.database.entity.User;
import org.timowa.spring.dto.UserFilter;

import java.util.List;

public interface FilterUserRepository {
    List<User> findAllByFilter(UserFilter filter);
}
