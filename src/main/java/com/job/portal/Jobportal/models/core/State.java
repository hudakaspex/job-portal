package com.job.portal.Jobportal.models.core;

import com.job.portal.Jobportal.models.enums.AppliedState;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class State {
    @Id
    private Integer id;

    private AppliedState state;

    private String description;
}
