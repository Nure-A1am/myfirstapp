package com.practice.myfirstapp.service;

import com.practice.myfirstapp.model.Employee;
import com.practice.myfirstapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDetailsServiceImpl implements UserDetailsService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeDetailsServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByEmailId(emailId);
        if (employee == null) {
            throw new UsernameNotFoundException("Employee not found");
        }
        return org.springframework.security.core.userdetails.User
                .withUsername(employee.getEmailId())
                .password(employee.getPassword())
                .roles(employee.getRole())
                .build();
    }

}
