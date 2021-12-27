package com.jobs.model;

public enum EmploymentType {
    FULLTIME("full time"), PARTTIME("part time");
    public final String employmentType;

    EmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }
}
