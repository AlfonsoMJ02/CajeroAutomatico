package CajeroAutomatico.Configuration;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {

        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();

        CorsConfiguration corsConfig = new CorsConfiguration();

        corsConfig.setAllowCredentials(true);

        corsConfig.setAllowedOrigins(List.of(
                "http://localhost:4200",
                "http://192.167.0.124:4200"
        ));

        corsConfig.setAllowedMethods(List.of(
                "GET",
                "POST",
                "PUT",
                "DELETE",
                "PATCH",
                "OPTIONS"
        ));

        corsConfig.setAllowedHeaders(List.of("*"));

        source.registerCorsConfiguration("/**", corsConfig);

        return new CorsFilter(source);
    }
}