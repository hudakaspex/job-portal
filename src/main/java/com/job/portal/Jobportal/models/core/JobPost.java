package com.job.portal.Jobportal.models.core;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
@Getter
@Setter
public class JobPost {

    @Id
    private Integer id;

    private String label;

    private String description;

    private Date startDate;

    private Date endDate;

    private Long salary;

    @OneToOne
    private Category category;

    @OneToOne
    private Qualification qualification;

}
