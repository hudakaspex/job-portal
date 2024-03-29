package com.job.portal.Jobportal.Security.models.dto;

import com.job.portal.Jobportal.Security.models.enums.UserRole;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Validated
public class RegisterReqDto {
    @NotBlank
    private String name;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String email;
    private String phone;
    private UserRole type;
}
