package com.job.portal.Jobportal.services.core;

import com.job.portal.Jobportal.models.core.Category;
import com.job.portal.Jobportal.models.core.JobPost;
import com.job.portal.Jobportal.repository.core.JobPostRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@Log4j2
@RunWith(MockitoJUnitRunner.class)
//https://stackoverflow.com/questions/66687062/spring-boot-junit-mockito-null-pointer-exception
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
//        GIVEN
        var jobPost = new JobPost();
        jobPost.setId(1);

//        WHEN
        when(jobPostRepository.findById(any(Integer.class))).thenReturn(Optional.of(jobPost));

//        THEN
        Optional<JobPost> jobPost1 = jobPostService.findById(1);

        assertThat(jobPost1.get().getId()).isNotNull();
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

        assertThat(jobPost1.getTitle()).isSameAs(jobPost.getTitle());
    }

    @Test
    void testUpdate() {
    }

    @Test
    void testDelete() {
    }
}