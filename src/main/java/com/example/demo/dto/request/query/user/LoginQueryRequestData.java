package com.example.demo.dto.request.query.user;

import com.example.demo.dto.request.query.QueryRequestData;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginQueryRequestData extends QueryRequestData {
    private String username;
    private String password;
}
