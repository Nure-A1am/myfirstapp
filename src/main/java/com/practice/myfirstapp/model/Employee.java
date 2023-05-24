package com.practice.myfirstapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;


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

    @NotNull(message = "This data can not be null!!")
    @NotEmpty(message = "This data can not be empty!!")
    @Column(name = "first_name")
    private String firstName;

    @NotNull(message = "This data can not be null!!")
    @NotEmpty(message = "This data can not be empty!!")
    @Column(name = "last_name")
    private String lastName;

    @NotNull(message = "This data can not be null!!")
    @NotEmpty(message = "This data can not be empty!!")
    @Column(name = "email_id")
    private String emailId;

    @NotNull(message = "This data can not be null!!")
    @NotEmpty(message = "This data can not be empty!!")
    @Column(name = "role")
    private String designation;

    @NotNull(message = "This data can not be null!!")
    @NotEmpty(message = "This data can not be empty!!")
    @Column(name = "salary")
    private String salary;
}
