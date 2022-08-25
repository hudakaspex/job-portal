package com.job.portal.Jobportal.Security.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Authority implements GrantedAuthority {

    @Id
    private Long id;

    private String name;

    private String description;

    @Override
    public String getAuthority() {
        return name;
    }
}
