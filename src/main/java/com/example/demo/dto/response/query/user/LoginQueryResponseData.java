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
public class LoginQueryResponseData extends QueryResponseData {
    private String accessToken;
    private String refreshToken;
    private Long expiresIn;
    private Long refreshExpiresIn;
    private String tokenType;
}
