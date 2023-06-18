package com.practice.myfirstapp;

import com.practice.myfirstapp.model.Employee;
import com.practice.myfirstapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DummyDataGenerator implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public DummyDataGenerator(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    private String encodePassword(String rawPassword) {
        // Encode the password using the BCryptPasswordEncoder
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        return passwordEncoder.encode(rawPassword);
    }

    @Override
    public void run(String... args) throws Exception {
        // Generate and save dummy data
        Employee employee1 = new Employee(1L, "Theo", "Joe", "hr@email.com", "pw123", "hr_manager", "30000.00");
        Employee employee2 = new Employee(2L, "Jane", "Smith", "it@email.com", "pw456", "it_support", "20000.00");
        Employee employee3 = new Employee(3L, "Adam", "Johnson", "sales@email.com", "pw789", "sales_executive", "12000.00");

        // Encode passwords
        employee1.setPassword(encodePassword(employee1.getPassword()));
        employee2.setPassword(encodePassword(employee2.getPassword()));
        employee3.setPassword(encodePassword(employee3.getPassword()));

        // Save employees
        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
        employeeRepository.save(employee3);
    }

}
