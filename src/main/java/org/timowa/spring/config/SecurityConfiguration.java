package org.timowa.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.timowa.spring.database.entity.Role;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
//                .csrf(CsrfConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "users/registration", "/v3/api-docs/", "/swagger-ui/").permitAll()
                        .requestMatchers("/admin/**").hasRole(Role.ADMIN.getAuthority())
                        .requestMatchers(antMatcher("/users/{\\d}/delete")).hasAnyAuthority(Role.ADMIN.getAuthority(), Role.OPERATOR.getAuthority())
                        .anyRequest().authenticated())
//                .httpBasic(Customizer.withDefaults());
                .formLogin(login -> login
                        .loginPage("/login")
                        .defaultSuccessUrl("/users")
                        .permitAll())
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login")
                        .deleteCookies("JSESSIONID"));
        return http.build();
    }
}
