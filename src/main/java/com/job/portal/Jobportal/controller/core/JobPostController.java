package com.job.portal.Jobportal.controller.core;

import com.job.portal.Jobportal.models.core.JobPost;
import com.job.portal.Jobportal.services.core.JobPostService;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api")
public class JobPostController {

    @Getter
    JobPostService jobPostService;

    JobPostController(JobPostService jobPostService) {
        this.jobPostService = jobPostService;
    }

    @GetMapping("/jobposts")
    public List<JobPost> getJobPosts() {
        return this.jobPostService.getJobsPosts();
    }

    @PostMapping("/jobposts")
    public JobPost createJobPost(@RequestBody JobPost jobPost) {
        return this.jobPostService.createJobPost(jobPost);
    }
}
