package com.flotting.api.util.type;

public enum EducationEnum {

    A("고등학교 졸업"), B("전문대 대학"), C("전문대 졸업"),
    D("대햑교 재학"), E("대학교 졸업"), F("대학원 재학"),
    G("대학원 졸업");

    private String value;

    EducationEnum(String value) {
        this.value = value;
    }
    public static EducationEnum of(String name) {
        return EducationEnum.valueOf(name);
    }

}
