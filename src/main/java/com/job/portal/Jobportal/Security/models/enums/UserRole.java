package com.job.portal.Jobportal.Security.models.enums;

public enum UserRole {
    RECRUITER("RECRUITER"),
    JOBSEEKER("JOBSEEKER"),

    // for test purpose
    TEST("TEST");
    public final String label;

    UserRole(String label) {
        this.label = label;
    }
}
