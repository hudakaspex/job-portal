package com.job.portal.Jobportal.controller.core;

import com.job.portal.Jobportal.models.core.JobPost;
import com.job.portal.Jobportal.services.core.JobPostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api")
public class JobPostController {

    JobPostService jobPostService;

    JobPostController(JobPostService jobPostService) {
        this.jobPostService = jobPostService;
    }

    @GetMapping("/jobposts")
    public List<JobPost> findALl() {
        return this.jobPostService.findAll();
    }

    @PostMapping("/jobposts")
    public JobPost create(@RequestBody JobPost jobPost) {
        return this.jobPostService.create(jobPost);
    }
}
