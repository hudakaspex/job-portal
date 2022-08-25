package com.job.portal.Jobportal.services.common;

import com.job.portal.Jobportal.models.common.Organization;
import com.job.portal.Jobportal.repository.common.OrganizationRepository;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService {
    private final OrganizationRepository organizationRepository;

    OrganizationService(
            OrganizationRepository organizationRepository
    ) {
        this.organizationRepository = organizationRepository;
    }

    public Organization create(Organization organization) {
        var result = this.organizationRepository.save(organization);
        return result;
    }

}
