package com.practice.myfirstapp.repository;


import com.practice.myfirstapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //all curd database methode
    Employee findByEmailId(String emailId);
//    boolean existsByEmailId(String emailId);
}
