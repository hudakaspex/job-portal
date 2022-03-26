package com.job.portal.Jobportal.models.core;

import com.job.portal.Jobportal.models.common.Address;
import com.job.portal.Jobportal.models.enums.EmploymentType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
@Getter
@Setter
public class Experience {
    @Id
    private Integer id;

    private String title;

    private String description;

    private String companyName;

    private Date startDate;

    private Date endDate;

    @OneToOne
    private Address address;

    private EmploymentType employmentType;
}
