package com.job.portal.Jobportal.Security.repository;

import com.job.portal.Jobportal.Security.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
