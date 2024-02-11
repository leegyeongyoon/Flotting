package com.flotting.api.user.enums;

public enum GradeEnum {

    D("D"), P("P"), G("G");

    private String name;

    GradeEnum(String name) {
        this.name = name;
    }

    public static GradeEnum of(String name) {
        return GradeEnum.valueOf(name);
    }

}
