package com.job.portal.Jobportal.models.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private Float latitude;

    private Float longitude;

    @OneToOne(targetEntity = Province.class)
    private Province province;

    /**
     * indicate that a field is not to be persisted in the database.
     * */
    @Transient
    private Integer province_id;

}
