package com.job.portal.Jobportal.models.core;


import com.job.portal.Jobportal.models.common.Organization;

import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Entity
public class Recruiter extends Organization {
    Recruiter() {
        super();
    }
}
