package com.jobs.model;

public enum IndustryType {
    TELECOM("Telecom"),ITCONSULTANCY("IT Consultany"),CREATIVESERVICES("Creative Services"),
    DATASERVICES("Data Services"),INFORMATIONSECURITY("Information security"),GAMING("Gaming"),
    ECOMMERCE("E commerce");

    public final String industryType;

    IndustryType(String industryType) {
        this.industryType = industryType;
    }
}
