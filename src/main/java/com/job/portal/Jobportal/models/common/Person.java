package com.job.portal.Jobportal.models.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
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
