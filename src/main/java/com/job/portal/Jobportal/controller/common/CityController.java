package com.job.portal.Jobportal.controller.common;

import com.job.portal.Jobportal.models.common.City;
import com.job.portal.Jobportal.services.common.CityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CityController {

    CityController(CityService cityService) {
    }

}
