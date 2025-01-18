package org.timowa.integration.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.timowa.annotation.IT;
import org.timowa.spring.database.entity.Role;
import org.timowa.spring.database.repository.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@IT
@RequiredArgsConstructor
@Slf4j
public class UserRepositoryTest {
    private final UserRepository userRepository;

    @Test
    void checkPageable() {
        var pageable = PageRequest.
                of(0, 2, Sort.by("id"));
        var slice = userRepository.findAllBy(pageable);

        slice.forEach(u -> System.out.println(u.getId()));

        while (slice.hasNext()) {
            slice = userRepository.findAllBy(slice.nextPageable());
            System.out.println("Next page");
            slice.forEach(u -> System.out.println(u.getId()));
        }

        assertFalse(slice.isEmpty());
        assertThat(slice).hasSize(2);
    }

    @Test
    void findFirst3ByTest() {
        var users = userRepository.findFirst3By(Sort.by("id").descending());
        assertFalse(users.isEmpty());
        log.info("Users = {}", users);
        assertThat(users).hasSize(3);
    }

    @Test
    void findFirstByCompanyIsNotNullOrderByIdDescTest() {
        var user = userRepository.findFirstByCompanyIsNotNullOrderByIdDesc();
        assertTrue(user.isPresent());
        user.ifPresent(u -> assertEquals("nagibator", u.getFirstname()));
    }

    @Test
    void checkProjections() {
        var users = userRepository.findAllByCompanyId(1);
        assertThat(users).hasSize(1);
    }

    @Test
    void updateRoleTest() {
        var entity1 = userRepository.findById(1L);
        assertTrue(entity1.isPresent());
        assertEquals(Role.ADMIN, entity1.get().getRole());

        var result = userRepository.updateRole(Role.USER, 1L);
        assertEquals(1, result);

        var entity2 = userRepository.findById(1L);
        assertTrue(entity2.isPresent());
        assertEquals(Role.USER, entity2.get().getRole());
    }

    @Test
    void findAllByFirstnameContainingAndLastnameContainingTest() {
        var users = userRepository
                .findAllByFirstnameContainingAndLastnameContaining("oh", "is");
        assertNotNull(users);
        assertFalse(users.isEmpty());
        assertThat(users).hasSize(1);
    }
}
