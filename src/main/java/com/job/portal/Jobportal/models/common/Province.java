package com.job.portal.Jobportal.models.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class Province {

    @Id
    @GeneratedValue()
    private Integer id;

    private String name;

    private Float latitude;

    private Float longitude;
}
