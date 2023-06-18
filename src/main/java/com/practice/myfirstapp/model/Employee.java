package com.practice.myfirstapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="employee")
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

     
    @NotEmpty(message = "This data can not be empty!!")
    @Column(name = "first_name")
    private String firstName;

     
    @NotEmpty(message = "This data can not be empty!!")
    @Column(name = "last_name")
    private String lastName;

     
    @NotEmpty(message = "This data can not be empty!!")
    @Column(name = "email_id")
    private String emailId;


    @NotEmpty(message = "This data cannot be empty!!")
    @Column(name = "password")
    private String password;


    @NotEmpty(message = "This data can not be empty!!")
    @Column(name = "role")
    private String role;

     
    @NotEmpty(message = "This data can not be empty!!")
    @Column(name = "salary")
    private String salary;

}
