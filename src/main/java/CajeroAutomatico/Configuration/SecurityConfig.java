package CajeroAutomatico.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        return http

                .csrf(csrf -> csrf.disable())

                .cors(Customizer.withDefaults())

                .sessionManagement(session ->
                        session.sessionFixation().migrateSession()
                )

                .authorizeHttpRequests(auth -> auth

                        .requestMatchers(
                                "/Auth/Login",
                                "/Banco/**",
                                "/Usuario/**",
                                "/Cajero/**"
                        ).permitAll()

                        .anyRequest().authenticated()
                )

                .formLogin(form -> form.disable())

                .httpBasic(httpBasic -> httpBasic.disable())

                .logout(logout -> logout.disable())

                .build();
    }
}