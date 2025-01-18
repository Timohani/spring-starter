package org.timowa.integration.repository;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.timowa.annotation.IT;
import org.timowa.spring.database.entity.Role;
import org.timowa.spring.database.repository.UserRepository;
import org.timowa.spring.dto.PersonalInfo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@IT
@RequiredArgsConstructor
public class UserRepositoryTest {
    private final UserRepository userRepository;

    @Test
    void checkProjections() {
        var users = userRepository.findAllByCompanyId(1, PersonalInfo.class);
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
