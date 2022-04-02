package com.job.portal.Jobportal.services.core;

import com.job.portal.Jobportal.models.core.JobPost;
import com.job.portal.Jobportal.repository.core.JobPostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobPostService {

    private final JobPostRepository jobPostRepository;

    JobPostService(JobPostRepository jobPostRepository) {
        this.jobPostRepository = jobPostRepository;
    }

    public List<JobPost> findAll() {
        return this.jobPostRepository.findAll();
    }

    public Optional<JobPost> findById(int id) {
        return this.jobPostRepository.findById(id);
    }

    public JobPost create(JobPost jobPost) {
        var jobPostSaved = this.jobPostRepository.save(jobPost);
        return jobPostSaved;
    }

    public JobPost update(JobPost jobPost) {
        var jobPostUpdated = this.jobPostRepository.save(jobPost);
        return jobPostUpdated;
    }

    public void delete(int id) {
       this.jobPostRepository.deleteById(id);
    }

    public void deleteByIds(List<Integer> ids) {
        this.jobPostRepository.deleteAllById(ids);
    }
}
