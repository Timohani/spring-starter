package org.timowa.spring.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.timowa.spring.database.entity.Role;
import org.timowa.spring.database.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    <T> List<T> findAllByCompanyId(Integer companyId, Class<T> clazz);

    List<User> findAllByFirstnameContainingAndLastnameContaining(String firstname, String lastname);

    @Modifying(clearAutomatically = true)
    @Query("update User u set u.role = :role " +
            "where u.id in (:ids)")
    int updateRole(Role role, Long... ids);
}
