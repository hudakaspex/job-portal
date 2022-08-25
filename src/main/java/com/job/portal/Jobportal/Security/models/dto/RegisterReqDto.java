package com.job.portal.Jobportal.Security.models.dto;

import com.job.portal.Jobportal.Security.models.enums.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterReqDto {
    private String name;
    private String username;
    private String password;
    private String email;
    private String phone;
    private UserRole type;
}
