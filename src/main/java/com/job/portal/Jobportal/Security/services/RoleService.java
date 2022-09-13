package com.job.portal.Jobportal.Security.services;

import com.job.portal.Jobportal.Security.models.Role;
import com.job.portal.Jobportal.Security.models.enums.UserRole;
import com.job.portal.Jobportal.Security.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
        initData();
    }

    private void initData() {
        var count = roleRepository.count();
        if (count == 0) {
            var jobseeker = new Role();
            jobseeker.setId(1L);
            jobseeker.setName(UserRole.JOBSEEKER);
            jobseeker.setDescription("Posting jobs");
            jobseeker.setAuthorities(List.of());

            var recruiter = new Role();
            recruiter.setId(2L);
            recruiter.setName(UserRole.RECRUITER);
            recruiter.setDescription("Search job");
            recruiter.setAuthorities(List.of());

            List<Role> roles = List.of(jobseeker, recruiter);
            roleRepository.saveAll(roles);
        }
    }
}
