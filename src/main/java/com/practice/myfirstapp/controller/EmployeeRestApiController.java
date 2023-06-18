package com.practice.myfirstapp.controller;


import com.practice.myfirstapp.exception.ResourceNotFoundException;
import com.practice.myfirstapp.model.Employee;
import com.practice.myfirstapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.practice.myfirstapp.configuration.AppConfigConstants.*;

@RestController
@RequestMapping(API_BASE_URL)

public class EmployeeRestApiController {

    @Autowired
    private EmployeeRepository employeeRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public EmployeeRestApiController(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    @GetMapping
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    // build create employee REST API
    @PostMapping(API_ADD_EMPLOYEE_URL)
    public Employee createEmployee(@RequestBody Employee employee){
        String rawPassword = employee.getPassword();
        // Encode the password using the PasswordEncoder
        String encodedPassword = passwordEncoder.encode(rawPassword);
        employee.setPassword(encodedPassword);
        return employeeRepository.save(employee);
    }


//    @GetMapping(EMPLOYEE_ID)
//    public ResponseEntity<?> getEmployeeByRole(@PathVariable long id) {
//        Employee employee = employeeRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with id:" + id));
//
//        if (employeeRepository.existsByEmailId(employee.getEmailId())) {
//            return ResponseEntity.badRequest().body("Email is already taken!");
//        }
//
//        return ResponseEntity.ok(employee);
//    }

    // build get employee by id REST API
    @GetMapping(EMPLOYEE_ID)
    public ResponseEntity<Employee> getEmployeeByRole(@PathVariable  long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
        return ResponseEntity.ok(employee);
    }

    // build update employee REST API
    @PutMapping(API_UPDATE_EMPLOYEE_URL + "{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails) {


        Employee updateEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmailId(employeeDetails.getEmailId());
        updateEmployee.setEmailId(employeeDetails.getPassword());
        updateEmployee.setRole(employeeDetails.getRole());
        updateEmployee.setSalary(employeeDetails.getSalary());

        employeeRepository.save(updateEmployee);
        return ResponseEntity.ok(updateEmployee);
    }

    // build delete employee REST API
    @DeleteMapping(EMPLOYEE_ID)
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

        employeeRepository.delete(employee);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
