package com.job.portal.Jobportal.repository.core;

import com.job.portal.Jobportal.models.core.Category;
import com.job.portal.Jobportal.models.core.JobPost;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataJpaTest
@Slf4j
class JobPostRepositoryTest {

    @Autowired
    private JobPostRepository jobPostRepository;

    @Test
    void testCreate() {
        var jobPost = new JobPost();
        var category = new Category();
        jobPost.setId(1);
        jobPost.setCategory(category);
        var result = this.jobPostRepository.save(jobPost);

        assertNotNull(result.getCategory().getId());
    }

}