package com.job.portal.Jobportal.services.core;

import com.job.portal.Jobportal.models.core.JobPost;
import com.job.portal.Jobportal.repository.core.JobPostRepository;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPostService {
    @Getter
    private final JobPostRepository jobPostRepository;

    JobPostService(JobPostRepository jobPostRepository) {
        this.jobPostRepository = jobPostRepository;
    }

    public List<JobPost> getJobsPosts() {
        return this.jobPostRepository.findAll();
    }

    public JobPost createJobPost(JobPost jobPost) {
        var jobPostSaved = this.jobPostRepository.save(jobPost);
        return jobPostSaved;
    }
}
