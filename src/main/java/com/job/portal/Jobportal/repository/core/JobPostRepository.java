package com.job.portal.Jobportal.repository.core;

import com.job.portal.Jobportal.models.core.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostRepository extends JpaRepository<JobPost, Integer> {
}