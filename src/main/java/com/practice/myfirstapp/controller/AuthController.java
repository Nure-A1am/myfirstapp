package com.practice.myfirstapp.controller;//package com.practice.myfirstapp.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static com.practice.myfirstapp.configuration.AppConfigConstants.*;

@Controller
public class AuthController {

    @Autowired
    private final AuthenticationManager authenticationManager;

    public AuthController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @GetMapping(LOGIN_PAGE_URL)
    public String loginPage(HttpServletRequest request, HttpServletResponse response) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (isAuthenticated()) {
            for (GrantedAuthority authority : authentication.getAuthorities()) {
                if (authority.getAuthority().equals("ROLE_it_support") || authority.getAuthority().equals("ROLE_hr_manager")) {
                    return "redirect:" + EMPLOYEE_LIST_URL;
                }
            }

            return "redirect:" + ACCESS_DENIED_PAGE_URL;
        }
            return "loginPage";
    }

    @GetMapping(INDEX_URL)
    public String welcomePage(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (isAuthenticated()) {
            for (GrantedAuthority authority : authentication.getAuthorities()) {
                if (authority.getAuthority().equals("ROLE_it_support") || authority.getAuthority().equals("ROLE_hr_manager")) {
                    return "redirect:" + EMPLOYEE_LIST_URL;
                }
            }

            return "redirect:" + ACCESS_DENIED_PAGE_URL;
        }

        return "welcome";
    }


    private boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || AnonymousAuthenticationToken.class.
                isAssignableFrom(authentication.getClass())) {
            return false;
        }
        return authentication.isAuthenticated();
    }

}
