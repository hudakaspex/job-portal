package com.job.portal.Jobportal.models.core;

import com.job.portal.Jobportal.models.enums.JobPostState;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
public class JobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;

    private String description;

    private Date startDate;

    private Date endDate;

    private Long salary;

    @OneToOne
    @NotNull
    private Category category;

    @OneToOne
    @Cascade(CascadeType.ALL)
    private Qualification qualification;

    private JobPostState state;
}
