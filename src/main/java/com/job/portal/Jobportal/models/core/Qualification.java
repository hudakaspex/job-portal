package com.job.portal.Jobportal.models.core;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Qualification {

    @Id
    private Integer id;

    @Column(name = "max_age")
    private Integer maxAge;

    @Column(name = "min_age")
    private Integer minAge;
}
