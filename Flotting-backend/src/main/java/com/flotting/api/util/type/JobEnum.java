package com.flotting.api.util.type;

public enum JobEnum {

    //공무원&공기업, 중견기업&대기업, 전문직, 사업가

    PUBLIC_COMPANY("공무원&공기업"), MID_MAJOR_COMPANY("중견기업&대기업"),
    PROFESSIONAL("전문"), BUSNINESS("사업가");

    private String name;

    JobEnum(String name) {
        this.name = name;
    }
    public static JobEnum of(String name) {
        return JobEnum.valueOf(name);
    }

}
