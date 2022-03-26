package com.job.portal.Jobportal.models.core;


import com.job.portal.Jobportal.models.common.Organization;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
public class Recruiter extends Organization {

    @OneToMany
    private List<JobPost> jobPosts;

    Recruiter() {
        super();
    }
}
