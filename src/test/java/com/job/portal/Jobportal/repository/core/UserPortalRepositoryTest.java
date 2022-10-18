package com.job.portal.Jobportal.repository.core;

import com.job.portal.Jobportal.Security.models.Role;
import com.job.portal.Jobportal.Security.models.UserCredentials;
import com.job.portal.Jobportal.Security.models.UserPortal;
import com.job.portal.Jobportal.Security.models.enums.UserRole;
import com.job.portal.Jobportal.Security.repository.RoleRepository;
import com.job.portal.Jobportal.Security.repository.UserRepository;
import com.job.portal.Jobportal.models.common.Party;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
@Slf4j
class UserPortalRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Test
    void findByEmailTest() {
        var user = createUserObj();
        userRepository.save(user);
        var userInfoByEmail = userRepository.findUserInfoByEmail("miftakhul341@gmail.com");
        Assertions.assertThat(userInfoByEmail).isNotEmpty();
    }

    private UserPortal createUserObj() {
        var user = new UserPortal();
        var userInfo = new Party();
        var credentials = new UserCredentials();

        userInfo.setEmail("miftakhul341@gmail.com");
        userInfo.setName("Mifta");
        userInfo.setPhone("08587757436");

        credentials.setUsername("mifta");
        credentials.setPassword("admin");

        user.setInfo(userInfo);
        user.setCredentials(credentials);

        return user;
    }

    @Test
    void findRoleByNameTest() {
        var newRole = new Role();
        newRole.setName(UserRole.JOBSEEKER);
        roleRepository.save(newRole);

        Optional<Role> role = roleRepository.findByName(UserRole.JOBSEEKER);

        Assertions.assertThat(role.isPresent()).isTrue();
    }
}
