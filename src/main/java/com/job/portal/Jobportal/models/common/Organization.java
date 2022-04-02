package com.job.portal.Jobportal.models.common;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Organization extends Party {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
}
