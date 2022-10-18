package com.job.portal.Jobportal.Security.repository;

import com.job.portal.Jobportal.Security.models.Role;
import com.job.portal.Jobportal.Security.models.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(UserRole name);
}
