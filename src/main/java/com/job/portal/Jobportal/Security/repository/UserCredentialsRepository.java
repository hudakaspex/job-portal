package com.job.portal.Jobportal.Security.repository;

import com.job.portal.Jobportal.Security.models.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserCredentialsRepository extends JpaRepository<UserCredentials, Long> {
        Optional<UserCredentials> findByUsername(String userName);
}
