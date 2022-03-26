package com.job.portal.Jobportal.controller.common;

import com.job.portal.Jobportal.services.common.CityService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CityController {

    CityController(CityService cityService) {
    }

}
