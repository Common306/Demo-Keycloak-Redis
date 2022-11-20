package com.example.demo.dto.response.query.user;

import com.example.demo.dto.response.query.QueryResponseData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserQueryResponseData extends QueryResponseData {
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String dob;
    private String address;
}
