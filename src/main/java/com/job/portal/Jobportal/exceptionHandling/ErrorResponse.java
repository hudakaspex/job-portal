package com.job.portal.Jobportal.exceptionHandling;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ErrorResponse {
    private Integer status;
    private HttpStatus error;
    private String message;
    private Long timestamp;
}
