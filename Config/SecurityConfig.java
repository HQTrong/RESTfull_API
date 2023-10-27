package tmdt.tmdt_api.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import tmdt.tmdt_api.Service.UserDetailsServicesImplement;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsImplement(){
        return new UserDetailsServicesImplement();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsImplement());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .requestMatchers("/categoryType").hasAuthority("admin")
                .requestMatchers("/product/**").hasAuthority("admin")
                .requestMatchers(HttpMethod.GET, "/account/**").hasAuthority("admin")
                .requestMatchers(HttpMethod.GET, "/comment").hasAuthority("admin")
                .requestMatchers(HttpMethod.POST, "/comment/**").hasAuthority("user")
                .requestMatchers(HttpMethod.POST, "/order/**").hasAuthority("user")
                .requestMatchers(HttpMethod.GET, "/order/**").hasAuthority("admin")
                .requestMatchers(HttpMethod.GET, "/customer/**").hasAuthority("admin")
                .requestMatchers(HttpMethod.POST, "/customer/**").hasAuthority("user")
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
        return http.build();
    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("trong")
//                .password("12345")
//                .roles("admin")
//                .build();
//        return new InMemoryUserDetailsManager(user);
//    }
}




