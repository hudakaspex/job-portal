package com.job.portal.Jobportal.services.common;

import com.job.portal.Jobportal.models.core.Recruiter;
import com.job.portal.Jobportal.repository.common.RecruiterRepository;
import org.springframework.stereotype.Service;

@Service
public class RecruiterService {
    private final RecruiterRepository recruiterRepository;

    RecruiterService(RecruiterRepository recruiterRepository
    ) {
        this.recruiterRepository = recruiterRepository;
    }

    public Recruiter create(Recruiter recruiter) {
        var result= this.recruiterRepository.save(recruiter);
        return result;
    }

}
