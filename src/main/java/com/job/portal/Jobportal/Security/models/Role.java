package com.job.portal.Jobportal.Security.models;

import com.job.portal.Jobportal.Security.models.enums.UserRole;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private UserRole name;

    private String description;

    @OneToMany
    private List<Authority> authorities;
}
