package com.job.portal.Jobportal.Security.services;

import com.job.portal.Jobportal.Security.exceptions.UserAlreadyExistException;
import com.job.portal.Jobportal.Security.models.UserCredentials;
import com.job.portal.Jobportal.Security.models.UserPortal;
import com.job.portal.Jobportal.Security.repository.UserRepository;
import com.job.portal.Jobportal.models.core.Jobseeker;
import com.job.portal.Jobportal.models.core.Recruiter;
import com.job.portal.Jobportal.services.common.JobSeekerService;
import com.job.portal.Jobportal.services.common.RecruiterService;
import com.job.portal.Jobportal.Security.models.dto.RegisterReqDto;
import com.job.portal.Jobportal.Security.models.mappers.Mapper;
import com.job.portal.Jobportal.Security.repository.UserCredentialsRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service()
public class UserService implements UserDetailsService {
    private final UserCredentialsRepository userCredentialsRepository;
    private final UserRepository userRepository;
    private final JobSeekerService jobSeekerService;
    private final RecruiterService recruiterService;
    private final Mapper mapper;

    public UserService(
            UserCredentialsRepository userCredentialsRepository,
            UserRepository userRepository, JobSeekerService jobSeekerService,
            RecruiterService recruiterService,
            Mapper mapper) {
        this.userCredentialsRepository = userCredentialsRepository;
        this.userRepository = userRepository;
        this.jobSeekerService = jobSeekerService;
        this.recruiterService = recruiterService;
        this.mapper = mapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var userForDb = userCredentialsRepository.findByUsername(username);
        UserDetails userDetails ;
        if (userForDb.isPresent()) {
            userDetails = new User(userForDb.get().getUsername(), userForDb.get().getPassword(), List.of());
        }
        else {
            throw new UsernameNotFoundException("User with username "+username+ " is not found");
        }
        return userDetails;
    }

    /**
     * Create new user
     * */
    public UserPortal create(RegisterReqDto registerReqDto) {
            UserPortal user = this.mapper.toUser(registerReqDto);

            // checking for username and email whether already use by registered user
            if (this.isEmailAlreadyExist(registerReqDto.getEmail()) || isUsernameAlreadyExist(registerReqDto.getUsername())) {
                throw new UserAlreadyExistException("An Account for that username/email already exists.");
            }

            switch (registerReqDto.getType()) {
                case JOBSEEKER:
                    user.getCredentials().getRole().setId(1L);
                    Jobseeker jobseeker = new Jobseeker(user);
                    return this.jobSeekerService.create(jobseeker);
                case RECRUITER:
                    // create user type RECRUITER
                    user.getCredentials().getRole().setId(2L);
                    Recruiter recruiter = new Recruiter(user);
                    return this.recruiterService.create(recruiter);
                default:
                    throw new IllegalArgumentException("Error");
            }
    }

    private boolean isEmailAlreadyExist(String email) {
        var retVal = false;
        Optional<UserPortal> user = this.userRepository.findUserInfoByEmail(email);
        if (user.isPresent()) {
            retVal = true;
        }
        return retVal;
    }

    private boolean isUsernameAlreadyExist(String username) {
        var retVal = false;
        Optional<UserCredentials> user = this.userCredentialsRepository.findByUsername(username);
        if (user.isPresent()) {
            retVal = true;
        }
        return retVal;
    }
}
