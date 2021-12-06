package com.job.portal.Jobportal.repository.common;

import com.job.portal.Jobportal.models.common.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
}
