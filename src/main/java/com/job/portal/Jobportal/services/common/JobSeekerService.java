package com.job.portal.Jobportal.services.common;

import com.job.portal.Jobportal.models.core.Jobseeker;
import com.job.portal.Jobportal.repository.common.JobSeekerRepository;
import org.springframework.stereotype.Service;

@Service
public class JobSeekerService {
    private final JobSeekerRepository jobSeekerRepository;

    JobSeekerService(
            JobSeekerRepository jobSeekerRepository,
            PersonService personService) {
        this.jobSeekerRepository = jobSeekerRepository;
    }

    public Jobseeker create(Jobseeker jobseeker) {
        var result =  this.jobSeekerRepository.save(jobseeker);
        return result;
    }
}
