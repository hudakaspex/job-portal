package com.job.portal.Jobportal.models.common;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.OneToOne;
import java.util.Date;

@Getter
@Setter
public abstract class Party {

    private String name;

    private Integer phone;

    private String email;

    @OneToOne
    private Address address;

    private Date birthDate;
}
