package com.example.demo.dto.request.command.user;

import com.example.demo.dto.request.command.CommandRequestData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterCommandRequestData extends CommandRequestData {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String dob;
    private String address;
}
