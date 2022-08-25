package com.job.portal.Jobportal.models.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class Person extends Party {

    @Column
    private String firstName;

    @Column
    private String midName;

    @Column
    private String lastName;

    public void setName(String name) {
       String arr[] = name.split(" ");
       switch (arr.length) {
           case 1:
               this.firstName = name;
               break;
           case 2:
               this.firstName = arr[0];
               this.midName = arr[1];
               break;
           default:
               this.firstName = arr[0];
               this.midName = arr[1];
               this.lastName = arr[2];
               break;
       }
    }
}
