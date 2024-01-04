package com.flotting.domain.type;

public enum AppliedPathEnum {

    A("소모임(클래스)"), B("소모임(모임)"), C("프립"),
    D("문토"), E("인스타그램"), F("지인 추천"),
    G("네이버 카페"), H("기타"), I("포탈 검색");

    private String value;

    AppliedPathEnum(String value) {
        this.value =value;
    }
    public static AppliedPathEnum of(String name) {
        return AppliedPathEnum.valueOf(name);
    }

}
