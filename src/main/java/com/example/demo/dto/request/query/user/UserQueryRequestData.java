package com.example.demo.dto.request.query.user;

import com.example.demo.dto.request.query.QueryRequestData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserQueryRequestData extends QueryRequestData {
    private String userId;
}
