package com.job.portal.Jobportal.services.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.job.portal.Jobportal.models.common.Province;
import com.job.portal.Jobportal.repository.common.ProvinceRepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProvinceService {

    @Getter
    ProvinceRepository provinceRepository;

    ProvinceService(ProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
        initTableProvince();
    }

    private void initTableProvince() {
        var count = provinceRepository.count();
        if (count == 0) {
            var provinces = getProvinceListFromJson();
            // Insert List Provinces to Database
            provinceRepository.saveAll(provinces);
        }
    }

    public List<Province> getProvinceListFromJson() {
        ObjectMapper mapper = new ObjectMapper();
        List<Province> provincesList = Arrays.asList();
        var resource = new ClassPathResource("locations/province.json");
        try {
            InputStream input = resource.getInputStream();
            provincesList = Arrays.stream(mapper.readValue(input, Province[].class))
                    .collect(Collectors.toList());
        } catch (IOException err) {
            err.printStackTrace();
        }
        return provincesList;
    }
}
