package com.job.portal.Jobportal.models.core;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.List;

@Entity
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Skill> skills;

    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Experience> expriences;

    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Education> educations;

}
