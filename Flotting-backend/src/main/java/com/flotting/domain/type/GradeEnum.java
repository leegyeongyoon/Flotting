package com.flotting.domain.type;

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
