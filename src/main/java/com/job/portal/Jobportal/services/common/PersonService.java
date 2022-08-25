package com.job.portal.Jobportal.services.common;

import com.job.portal.Jobportal.models.common.Person;
import com.job.portal.Jobportal.repository.common.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public Person create(Person person) {
        var result = this.personRepository.save(person);
        return result;
    }
}
