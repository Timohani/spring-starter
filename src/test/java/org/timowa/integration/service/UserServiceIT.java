package org.timowa.integration.service;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.timowa.annotation.IT;
import org.timowa.spring.database.entity.Role;
import org.timowa.spring.dto.UserCreatedEditDto;
import org.timowa.spring.dto.UserReadDto;
import org.timowa.spring.service.UserService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@IT
@RequiredArgsConstructor
class UserServiceIT {

    private final static Long USER_1 = 1L;
    private final static Integer COMPANY_1 = 1;
    private final UserService userService;

    @Test
    void findAll() {
        List<UserReadDto> result = userService.findAll();
        assertThat(result).hasSize(4);
    }

    @Test
    void findById() {
        Optional<UserReadDto> maybeUser = userService.findById(USER_1);
        assertTrue(maybeUser.isPresent());
        maybeUser.ifPresent(user -> assertEquals("john", user.getUsername()));
    }

    @Test
    void create() {
        UserCreatedEditDto userDto = new UserCreatedEditDto(
                "test",
                LocalDate.now(),
                "Test",
                "Test",
                Role.USER,
                COMPANY_1
        );
        UserReadDto actualResult = userService.create(userDto);

        assertEquals(userDto.getUsername(), actualResult.getUsername());
        assertEquals(userDto.getBirthDate(), actualResult.getBirthDate());
        assertEquals(userDto.getFirstname(), actualResult.getFirstname());
        assertEquals(userDto.getLastname(), actualResult.getLastname());
        assertEquals(userDto.getCompanyId(), actualResult.getCompany().id());
        assertSame(userDto.getRole(), actualResult.getRole());
    }

    @Test
    void update() {
        UserCreatedEditDto userDto = new UserCreatedEditDto(
                "test",
                LocalDate.now(),
                "Test",
                "Test",
                Role.USER,
                COMPANY_1
        );
        Optional<UserReadDto> actualResult = userService.update(USER_1, userDto);

        assertTrue(actualResult.isPresent());

        actualResult.ifPresent(user -> {
            assertEquals(userDto.getUsername(), user.getUsername());
            assertEquals(userDto.getBirthDate(), user.getBirthDate());
            assertEquals(userDto.getFirstname(), user.getFirstname());
            assertEquals(userDto.getLastname(), user.getLastname());
            assertEquals(userDto.getCompanyId(), user.getCompany().id());
            assertSame(userDto.getRole(), user.getRole());
        });
    }

    @Test
    void delete() {
        assertFalse(userService.delete(-124L));
        assertTrue(userService.delete(USER_1));
    }
}
