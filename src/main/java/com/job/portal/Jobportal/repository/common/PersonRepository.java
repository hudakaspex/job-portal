package com.job.portal.Jobportal.repository.common;

import com.job.portal.Jobportal.models.common.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
