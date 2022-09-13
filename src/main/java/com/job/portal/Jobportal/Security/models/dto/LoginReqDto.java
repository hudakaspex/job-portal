package com.job.portal.Jobportal.Security.models.dto;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Data
@Validated
public class LoginReqDto {
    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
