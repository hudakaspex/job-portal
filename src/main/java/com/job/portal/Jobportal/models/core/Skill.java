package com.job.portal.Jobportal.models.core;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Skill {
    @Id
    private Integer id;

    private String name;

    private String description;
}
