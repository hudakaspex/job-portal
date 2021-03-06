package com.job.portal.Jobportal.models.common;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String street;

    @OneToOne
    @JoinColumn(name = "province_id")
    private Province province;

    @OneToOne
    @JoinColumn(name = "city_id")
    private City city;

    private Integer postalCode;
}
