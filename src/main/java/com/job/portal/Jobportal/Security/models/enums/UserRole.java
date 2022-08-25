package com.job.portal.Jobportal.Security.models.enums;

public enum UserRole {
    RECRUITER("RECRUITER"),
    JOBSEEKER("JOBSEEKER");

    public final String label;

    UserRole(String label) {
        this.label = label;
    }
}
