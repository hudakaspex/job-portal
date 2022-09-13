package com.job.portal.Jobportal.controller.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.job.portal.Jobportal.models.core.Category;
import com.job.portal.Jobportal.models.core.JobPost;
import com.job.portal.Jobportal.services.core.JobPostService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(JobPostController.class)
class JobPostControllerTest {

    @MockBean
    JobPostService jobPostService;

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Test
    void create() throws Exception {

        // ketika Service melakukan create dan mengembalikan nilai, kemudian kita akan mengetest API kita
        when(jobPostService.create(any(JobPost.class))).thenReturn(new JobPost());

        // test API
            mockMvc.perform(post("/api/jobposts")
                            .content(mapper.writeValueAsString(new JobPost()))
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andExpect(jsonPath("$.label").value(null));
    }
}