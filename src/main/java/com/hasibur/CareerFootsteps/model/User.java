package com.hasibur.CareerFootsteps.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotEmpty(message = "Please Enter Your First Name!")
    @Column(nullable = false)
    private String firstName;

    @NotEmpty(message = "Please Enter Your Last Name!")
    @Column(nullable = false)
    private String lastName;

    @Email(message = "Please Enter Valid Email!")
    @Column(nullable = false)
    private String email;

    @Size(min = 4, message = "Your username should be at least 4 characters!")
    @Column(nullable = false, unique = true)
    private String username;

    @Size(min = 5, message = "Password should be at least 5 characters!")
    @Column(nullable = false)
    private String password;

    private String role = "USER";

}
