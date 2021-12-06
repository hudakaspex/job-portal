package com.job.portal.Jobportal.services.common;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.job.portal.Jobportal.models.common.City;
import com.job.portal.Jobportal.models.common.Province;
import com.job.portal.Jobportal.repository.common.CityRepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CityService {

    @Getter
    CityRepository cityRepository;

    @Getter
    ProvinceService provinceService;

    CityService(
            CityRepository cityRepository,
            ProvinceService provinceService
    ) {
        this.cityRepository = cityRepository;
        this.provinceService = provinceService;
        initTableCity();
    }

    private void initTableCity() {
        var count = cityRepository.count();
        if (count == 0) {
        ObjectMapper mapper = new ObjectMapper();
        var resource = new ClassPathResource("locations/cities.json");
        try {
            InputStream input = resource.getInputStream();
            var cities = mapper.readValue(input, City[].class);
            var provinceFromJson = provinceService.getProvinceListFromJson();
            var provinces = provinceService.provinceRepository.findAll();

            var cityAdded = Arrays.stream(cities).map(city -> {
                for (Province province : provinceFromJson) {
                    if (city.getProvince_id().equals(province.getId())) {
                        provinces.forEach(val -> {
                            if (val.getName().equals(province.getName())) {
                                city.setProvince(val);
                            }
                        });
                    }
                }
                return city;
            }).collect(Collectors.toList());

            // insert city to database
            cityRepository.saveAll(cityAdded).forEach(city -> {
                log.info(city.toString());
            });

        } catch (IOException err) {
            err.printStackTrace();
        }
       }
    }
}
