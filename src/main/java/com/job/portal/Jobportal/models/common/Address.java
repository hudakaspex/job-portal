package com.job.portal.Jobportal.models.common;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue()
    private Integer id;

    private String street;

    @OneToOne
    @JoinColumn(name = "province_id")
    private Province province;

    @OneToOne
    private City city;

    private Integer postalCode;
}
