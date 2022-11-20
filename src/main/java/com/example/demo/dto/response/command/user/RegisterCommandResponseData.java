package com.example.demo.dto.response.command.user;

import com.example.demo.dto.response.command.CommandResponseData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterCommandResponseData extends CommandResponseData {
    private String accessToken;
    private String refreshToken;
    private Long expiresIn;
    private Long refreshExpiresIn;
    private String tokenType;
}
