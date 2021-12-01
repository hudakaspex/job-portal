package com.job.portal.Jobportal.models.core;

import com.job.portal.Jobportal.models.common.Person;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Setter
@Getter
public class Jobseeker extends Person {
    private String firstName;

    private String midName;

    private String lastName;
}
