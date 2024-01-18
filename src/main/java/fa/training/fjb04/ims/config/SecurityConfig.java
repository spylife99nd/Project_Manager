package fa.training.fjb04.ims.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain httpSecurityFilterChain(HttpSecurity http) throws Exception {

    http.authorizeHttpRequests(config -> config
        .requestMatchers("/css/**","/img/**","/js/**", "/img/**", "/error","/home/**", "/schedule/**")
        .permitAll());

    return http.build();

  }
}
