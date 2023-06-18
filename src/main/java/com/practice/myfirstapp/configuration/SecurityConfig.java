package com.practice.myfirstapp.configuration;

import com.practice.myfirstapp.service.EmployeeDetailsServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import static com.practice.myfirstapp.configuration.AppConfigConstants.*;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final EmployeeDetailsServiceImpl employeeDetailsService;

    @Autowired
    public SecurityConfig(EmployeeDetailsServiceImpl employeeDetailsService) {
        this.employeeDetailsService = employeeDetailsService;
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return new ProviderManager(Arrays.asList(authenticationProvider()));
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Bean
    public SecurityFilterChain filterChainFrontend(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests((authorize) ->
                        authorize
                                .requestMatchers(PUBLIC_PAGE_ACCESS).permitAll()
                                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                                .requestMatchers(AUTHORIZED_PAGE_ACCESS).hasAnyRole(AUTHORIZED_EMPLOYEE_ROLES)
                                .requestMatchers(OTHER_EMPLOYEE_PAGE_ACCESS).hasAnyRole(GENERAL_EMPLOYEE_ROLES)
                                .requestMatchers(LOGIN_PAGE_URL + INDEX_URL).anonymous()
                                .anyRequest().authenticated()
                )
                .formLogin(
                        form -> form
                                .loginPage(LOGIN_PAGE_URL)
                                .loginProcessingUrl(LOGIN_PAGE_URL)
                                .successHandler((request, response, authentication) -> {
                                    // Retrieve the authorities/roles of the authenticated user
                                    Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
                                    // Redirect the user based on their role
                                    if (authorities.stream().anyMatch(a -> a.getAuthority().equals("ROLE_it_support"))) {
                                        response.sendRedirect(EMPLOYEE_LIST_URL); // Redirect to admin page for IT support
                                    } else if (authorities.stream().anyMatch(a -> a.getAuthority().equals("ROLE_hr_manager"))) {
                                        response.sendRedirect(EMPLOYEE_LIST_URL); // Redirect to HR page for HR manager
                                    } else {
                                        response.sendRedirect(ACCESS_DENIED_PAGE_URL); // Redirect to general user page for other roles
                                    }

                                })
                                .failureUrl(LOGIN_ERROR_PAGE_URL)
                                .permitAll()
                )

                .logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher(LOGOUT_PAGE_URL))
                                .logoutSuccessUrl(LOGOUT_SUCCESS_PAGE_URL)
                                .permitAll()
                );

        return http.build();
    }

//    @Bean
//    public SecurityFilterChain filterChainRestApi(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((authorize) ->
//                        authorize
//                                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
//                                .requestMatchers(HttpMethod.GET, ALL_API_URL_PATTERN).permitAll()
//                                .requestMatchers(ALL_API_URL).hasAnyRole(AUTHORIZED_EMPLOYEE_ROLES)
//                                .requestMatchers(AUTHORIZED_PAGE_ACCESS).hasAnyRole(AUTHORIZED_EMPLOYEE_ROLES)
//                                .anyRequest().authenticated()
//                );
//        return http.build();
//    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        // Configure the authentication provider here
        authenticationProvider.setUserDetailsService(employeeDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return employeeDetailsService;
    }

    // Define your custom AccessDeniedHandler
    private AccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    // Custom AccessDeniedHandler implementation
    private static class CustomAccessDeniedHandler implements AccessDeniedHandler {
        @Override
        public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
            // Customize the behavior when access is denied
            response.sendRedirect(ACCESS_DENIED_PAGE_URL); // Redirect to the access denied page
        }
    }


}


