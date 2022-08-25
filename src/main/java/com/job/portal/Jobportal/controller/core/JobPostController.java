package com.job.portal.Jobportal.controller.core;

import com.job.portal.Jobportal.models.core.JobPost;
import com.job.portal.Jobportal.services.core.JobPostService;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class JobPostController {

    JobPostService jobPostService;

    JobPostController(JobPostService jobPostService) {
        this.jobPostService = jobPostService;
    }

    @GetMapping("/jobposts")
    public List<JobPost> findALl() {
        var jobPosts =  this.jobPostService.findAll();
        return jobPosts;
    }

    @PostMapping("/jobposts")
    public JobPost create(@RequestBody JobPost jobPost) {
        return this.jobPostService.create(jobPost);
    }

    @GetMapping("/jobposts/{id}")
    public Optional<JobPost> findById(@PathVariable Integer id) {
        var jobPost = this.jobPostService.findById(id);
        if (jobPost.isEmpty()) {
            throw new NullPointerException("Job Post Not found");
        }
        else {
            return jobPost;
        }
    }

    @PutMapping("/jobposts/{id}")
    public JobPost update(@PathVariable Integer id, @RequestBody() JobPost jobPost) {
        return this.jobPostService.update(jobPost);
    }

    @DeleteMapping("jobposts/{id}")
    public ResponseEntity<Integer> delete(@PathVariable Integer id) {
        var jobPost = this.jobPostService.findById(id);
        if (jobPost.isPresent()) {
            this.jobPostService.delete(id);
            return new ResponseEntity(id, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("jobposts/deleteByIds")
    public void deleteByIds(@RequestBody List<Integer> ids) {
        this.jobPostService.deleteByIds(ids);
    }
}
