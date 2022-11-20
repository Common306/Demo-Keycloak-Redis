package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String dob;
    private String address;
}
