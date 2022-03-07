package com.job.portal.Jobportal.models.core;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
public class AppliedJob {
    @Id
    private Integer id;

    @OneToOne
    private JobPost jobPost;

    @OneToOne
    private Resume resume;

    private String state;
}
