package com.flotting.api.util.type;

public enum DrinkingEnum {

    A("자주 마심(주3회 이상)"), B("가끔 마심(주2회 이상)"),
    C("거의 안 마심(월 1~2회)"), D("아예 안 마심(월 1회 이하)");

    private String value;

    DrinkingEnum(String value) {
        this.value = value;
    }
    public static DrinkingEnum of(String name) {
        return DrinkingEnum.valueOf(name);
    }

}
