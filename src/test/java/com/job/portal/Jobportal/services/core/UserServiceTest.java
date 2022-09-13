package com.job.portal.Jobportal.services.core;

import com.job.portal.Jobportal.Security.exceptions.UserAlreadyExistException;
import com.job.portal.Jobportal.Security.models.UserCredentials;
import com.job.portal.Jobportal.Security.models.UserPortal;
import com.job.portal.Jobportal.Security.models.dto.RegisterReqDto;
import com.job.portal.Jobportal.Security.models.enums.UserRole;
import com.job.portal.Jobportal.Security.models.mappers.Mapper;
import com.job.portal.Jobportal.Security.repository.UserCredentialsRepository;
import com.job.portal.Jobportal.Security.repository.UserRepository;
import com.job.portal.Jobportal.Security.services.UserService;
import com.job.portal.Jobportal.models.core.Jobseeker;
import com.job.portal.Jobportal.models.core.Recruiter;
import com.job.portal.Jobportal.services.common.JobSeekerService;
import com.job.portal.Jobportal.services.common.RecruiterService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    JobSeekerService jobSeekerService;

    @Mock
    RecruiterService recruiterService;

    @Mock
    UserCredentialsRepository userCredentialsRepository;

    @Mock
    UserRepository userRepository;

    @Mock
    Mapper mapper;

    @InjectMocks
    UserService userService;

    @Test
    void testCreateJobseeker() {
        var registerDto = createRegisterDTO();

        Mapper mapUser = new Mapper();
        UserPortal user = mapUser.toUser(registerDto);
        Jobseeker jobseeker = new Jobseeker(user);

        Mockito.when(this.mapper.toUser(any(RegisterReqDto.class))).thenReturn(user);

        Mockito.when(this.jobSeekerService.create(any(Jobseeker.class))).thenReturn(jobseeker);

        UserPortal userPortal = this.userService.create(registerDto);

        Assertions.assertThat(userPortal).isNotNull();
        Assertions.assertThat(userPortal.getCredentials().getRole().getName()).isSameAs(UserRole.JOBSEEKER);
    }

    @Test
    void testCreateRecruiter() {
        var registerDto = createRegisterDTO();
        registerDto.setType(UserRole.RECRUITER);

        Mapper mapUser = new Mapper();
        UserPortal user = mapUser.toUser(registerDto);
        Recruiter recruiter = new Recruiter(user);

        Mockito.when(this.mapper.toUser(any(RegisterReqDto.class))).thenReturn(user);

        Mockito.when(this.recruiterService.create(any(Recruiter.class))).thenReturn(recruiter);

        UserPortal userPortal = this.userService.create(registerDto);

        Assertions.assertThat(userPortal).isNotNull();
        Assertions.assertThat(userPortal.getCredentials().getRole().getName())
                .isSameAs(UserRole.RECRUITER);
    }

    @Test
    void whenEmailExistThrownException() {
        var registerDto = createRegisterDTO();
        Mockito.when(this.userRepository.findUserInfoByEmail(anyString()))
                .thenReturn(Optional.of(new UserPortal()));

        Assertions.assertThatThrownBy(() -> this.userService.create(registerDto))
                .isInstanceOf(UserAlreadyExistException.class);
    }

    @Test
    void whenUsernameExistThrownException() {
        var registerDto = createRegisterDTO();
        Mockito.when(this.userCredentialsRepository.findByUsername(anyString()))
                .thenReturn(Optional.of(new UserCredentials()));

        Assertions.assertThatThrownBy(() -> this.userService.create(registerDto))
                .isInstanceOf(UserAlreadyExistException.class);
    }

    @Test
    void testWrongType() {
        var registerDto = new RegisterReqDto();
        registerDto.setUsername("Huda");
        registerDto.setName("Huda");
        registerDto.setPassword("test");
        registerDto.setEmail("huda@gmail.com");
        registerDto.setType(UserRole.valueOf("TEST"));

        Assertions.assertThatThrownBy(() -> userService.create(registerDto)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testSuccessLoadUserByUserName() {
        UserCredentials user = new UserCredentials();
        user.setUsername("Huda");
        user.setPassword("Admin");
        Mockito.when(userCredentialsRepository.findByUsername(anyString())).thenReturn(Optional.of(user));

        UserDetails userRet = userService.loadUserByUsername("Huda");

        Assertions.assertThat(userRet).isNotNull();
    }

    @Test
    void testNotfoundLoadUser() {
        UserCredentials user = new UserCredentials();
        user.setUsername("Huda");
        user.setPassword("Admin");
        Mockito.when(userCredentialsRepository.findByUsername(anyString()))
                .thenReturn(Optional.empty());

        Assertions.assertThatThrownBy(() -> userService.loadUserByUsername("Huda"))
                .isInstanceOf(UsernameNotFoundException.class);
    }

    private RegisterReqDto createRegisterDTO() {
        var registerDto = new RegisterReqDto();
        registerDto.setUsername("Huda");
        registerDto.setName("Huda");
        registerDto.setPassword("test");
        registerDto.setEmail("huda@gmail.com");
        registerDto.setType(UserRole.JOBSEEKER);
        return registerDto;
    }


}
