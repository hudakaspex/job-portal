package com.job.portal.Jobportal.models.core;

import com.job.portal.Jobportal.Security.models.UserPortal;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Setter
@Getter
public class Jobseeker extends UserPortal {

    @OneToOne
    @Cascade(CascadeType.ALL)
    @JoinColumn()
    private Resume resume;

    public Jobseeker() {
        super();
    }

    public Jobseeker(UserPortal userPortal) {
        super(userPortal);
    }
}
