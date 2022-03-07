package com.job.portal.Jobportal.models.common;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Person extends Party {
    @Id
    private Integer id;

    @Column
    private String firstName;

    @Column
    private String midName;

    @Column
    private String lastName;
}
