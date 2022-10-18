package com.job.portal.Jobportal.Security.models.mappers;

import com.job.portal.Jobportal.Security.models.UserCredentials;
import com.job.portal.Jobportal.Security.models.UserPortal;
import com.job.portal.Jobportal.Security.models.Role;
import com.job.portal.Jobportal.Security.models.dto.RegisterReqDto;
import com.job.portal.Jobportal.Security.models.dto.RegisterResDto;
import com.job.portal.Jobportal.Security.models.enums.UserRole;
import com.job.portal.Jobportal.models.common.Organization;
import com.job.portal.Jobportal.models.common.Party;
import com.job.portal.Jobportal.models.common.Person;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component()
public class Mapper {

    public UserPortal toUser(RegisterReqDto registerReqDto) {
        UserCredentials userCredentials = new UserCredentials();

        //INFO
        Party party = null;
        if (registerReqDto.getType() == UserRole.JOBSEEKER) {
            party = this.createPerson(registerReqDto);
        }
        else {
            party = this.createOrg(registerReqDto);
        }

        // ROLE
        Role role = new Role();
        role.setName(registerReqDto.getType());

        // Generate credentials
        userCredentials.setPassword(registerReqDto.getPassword());
        userCredentials.setUsername(registerReqDto.getUsername());
        userCredentials.setRole(role);
        userCredentials.setCreatedDate(new Date());

        //USER
        UserPortal userPortal = new UserPortal();
        userPortal.setId(null);
        userPortal.setCredentials(userCredentials);
        userPortal.setInfo(party);

        return userPortal;
    }

    private Person createPerson(RegisterReqDto reqDto) {
        Person person = new Person();
        person.setEmail(reqDto.getEmail());
        person.setPhone(reqDto.getPhone());
        person.setSplitName(reqDto.getName());
        return person;
    }

    private Organization createOrg(RegisterReqDto reqDto) {
        Organization organization = new Organization();
        organization.setEmail(reqDto.getEmail());
        organization.setPhone(reqDto.getPhone());
        organization.setName(reqDto.getName());
        return organization;
    }

    public RegisterResDto toRegisterResponseDto(UserPortal user) {
        RegisterResDto registerResDto = new RegisterResDto();
        registerResDto.setUsername(user.getCredentials().getUsername());
        registerResDto.setName(user.getInfo().getName());
        registerResDto.setEmail(user.getInfo().getEmail());
        return registerResDto;
    }
}
