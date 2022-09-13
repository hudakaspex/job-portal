package com.job.portal.Jobportal.services.core;

import com.job.portal.Jobportal.models.core.JobPost;
import com.job.portal.Jobportal.repository.core.JobPostRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@Log4j2
@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
class JobPostServiceTest {

    @Mock
    JobPostRepository jobPostRepository;

    @InjectMocks
    JobPostService jobPostService;

    @Test
    void testFindAll() {
    }

    @Test
    void testFindById() {
        // GIVEN
        var jobPost = new JobPost();
        jobPost.setId(1);

        // WHEN
        when(jobPostRepository.findById(1)).thenReturn(Optional.of(jobPost));

        // THEN
        Optional<JobPost> jobPost1 = jobPostService.findById(1);

        Assertions.assertNotNull(jobPost1);

        Mockito.verify(jobPostRepository, times(1)).findById(1);
    }

    @Test
    void testCreate() {
        //GIVEN
        var jobPost = new JobPost();
        jobPost.setTitle("Front End Developer");

        //WHEN
        when(this.jobPostRepository.save(any(JobPost.class))).thenReturn(jobPost);

        //THEN
        JobPost jobPost1 = this.jobPostService.create(jobPost);
        jobPostRepository.count();

        verify(jobPostRepository).count();

    }

    @Test
    void testUpdate() {
    }

    @Test
    void testDelete() {
    }
}