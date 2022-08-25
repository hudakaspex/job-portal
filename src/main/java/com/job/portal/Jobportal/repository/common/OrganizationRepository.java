package com.job.portal.Jobportal.repository.common;

import com.job.portal.Jobportal.models.common.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}
