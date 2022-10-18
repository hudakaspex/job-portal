package com.job.portal.Jobportal.Security.models.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * Data transfer object for response to client after register new user
 * */
public class RegisterResDto {
    private String username;
    private String name;
    private String email;
}
