package com.job.portal.Jobportal.models.common;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class Province {

    @Id
    @GeneratedValue()
    private Integer id;

    private String name;

    private Integer latitude;

    private Integer longitude;

    @OneToMany()
    private List<City> cities;
}
