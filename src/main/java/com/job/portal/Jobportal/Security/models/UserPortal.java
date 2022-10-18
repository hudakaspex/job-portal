package com.job.portal.Jobportal.Security.models;

import com.job.portal.Jobportal.models.common.Party;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Entity(name = "User")
public class UserPortal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private UserCredentials credentials;

    @OneToOne(cascade = CascadeType.PERSIST, targetEntity = Party.class)
    private Party info;

    public UserPortal() {
    }

    public UserPortal(UserPortal userPortal) {
        setId(userPortal.getId());
        setInfo(userPortal.getInfo());
        setCredentials(userPortal.getCredentials());
    }

}
