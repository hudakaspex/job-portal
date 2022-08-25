package com.job.portal.Jobportal.models.core;

import com.job.portal.Jobportal.Security.models.UserPortal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Recruiter extends UserPortal {

    @OneToMany()
    private List<JobPost> jobPosts;


    public Recruiter(UserPortal userPortal) {
        super(userPortal);
    }
}
