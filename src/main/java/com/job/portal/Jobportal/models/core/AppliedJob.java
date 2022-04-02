package com.job.portal.Jobportal.models.core;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
public class AppliedJob {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    private JobPost jobPost;

    @OneToOne
    private Resume resume;

    @OneToOne
    private AppliedJobState state;
}
