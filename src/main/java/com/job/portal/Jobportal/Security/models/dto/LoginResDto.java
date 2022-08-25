package com.job.portal.Jobportal.Security.models.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResDto {
    private String token;

    public LoginResDto(String token) {
        this.token = token;
    }
}
