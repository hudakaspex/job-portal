package com.job.portal.Jobportal.models.core;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
public class Education {
    @Id
    private Integer id;

    private String school;

    private String degree;

    private String fieldOfStudy;

    private Date startDate;

    private Date endDate;

    private String description;
}
