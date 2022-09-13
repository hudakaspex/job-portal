package com.job.portal.Jobportal.models.common;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
public class Party {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(unique = true)
    private String phone;

    @Column(unique = true)
    private String email;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    private Date birthDate;
}
