package com.job.portal.Jobportal.Security.repository;

import com.job.portal.Jobportal.Security.models.UserPortal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserPortal, Long> {
}
