package com.job.portal.Jobportal.repository.common;

import com.job.portal.Jobportal.models.core.Jobseeker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerRepository extends JpaRepository<Jobseeker, Integer> {
}
