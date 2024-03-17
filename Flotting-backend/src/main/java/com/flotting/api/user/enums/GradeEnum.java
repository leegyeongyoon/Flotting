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

    public static GradeEnum getUpperGrade(GradeEnum grade) {
        if(GradeEnum.G.equals(grade)) {
            return GradeEnum.P;
        } else  {
            return GradeEnum.D;
        }
    }
}
