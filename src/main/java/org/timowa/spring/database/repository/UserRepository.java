package org.timowa.spring.database.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.timowa.spring.database.entity.Role;
import org.timowa.spring.database.entity.User;
import org.timowa.spring.dto.IPersonalInfo;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>, FilterUserRepository {

    Page<User> findAllBy(Pageable pageable);

    List<User> findFirst3By(Sort sort);
    
    Optional<User> findFirstByCompanyIsNotNullOrderByIdDesc();

    @Query(value = "SELECT u.firstname, u.lastname, u.birth_date FROM users u " +
            "WHERE company_id = :companyId",
            nativeQuery = true)
    List<IPersonalInfo> findAllByCompanyId(Integer companyId);

    List<User> findAllByFirstnameContainingAndLastnameContaining(String firstname, String lastname);

    @Modifying(clearAutomatically = true)
    @Query("update User u set u.role = :role " +
            "where u.id in (:ids)")
    int updateRole(Role role, Long... ids);
}
