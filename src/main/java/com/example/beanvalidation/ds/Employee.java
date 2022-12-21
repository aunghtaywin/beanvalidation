package com.example.beanvalidation.ds;

import com.example.beanvalidation.validation.NameNotAdmin;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @NameNotAdmin(message = "Name cannot be admin!")
    @NotEmpty(message = "{myapp.validation.msg.firstname}")
    private String firstName;
    @NotEmpty(message = "LastName cannot be empty!")
    private String lastName;
    @Min(value = 18, message = "You are too young!")
    @Max(value = 60, message = "You are too old!")
    private int age;
    @NotEmpty(message = "Email cannot be empty!")
    @Email(message = "invalid email format!")
    private String email;
}
