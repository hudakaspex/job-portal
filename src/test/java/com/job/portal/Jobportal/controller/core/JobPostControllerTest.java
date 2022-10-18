package com.job.portal.Jobportal.controller.core;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(JobPostController.class)
@Slf4j
class JobPostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void create() {
        log.info("TEST");
    }
}