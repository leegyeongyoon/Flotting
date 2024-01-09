package com.flotting.api.util.type;

public enum BodyEnum {

    NORMAL("평균"), SLIM("슬림"), VOLUME("볼륨"), SOLID("탄탄"),
    CHUBBY("통통"), RELIABLE("듬직"), MUSCULAR("근육질");

    private String name;

    BodyEnum(String name) {
        this.name = name;
    }

    public static BodyEnum of(String name) {
        return BodyEnum.valueOf(name);
    }
}
