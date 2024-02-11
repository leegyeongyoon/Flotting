package com.flotting.api.user.enums;

public enum AppliedPathEnum {

    SMALL_CLASS_C("소모임(클래스)"), SMALL_CLASS_M("소모임(모임)"), FRIP("프립"),
    MOONTO("문토"), INSTA("인스타그램"), RECOMMEND("지인 추천"),
    NAVER("네이버 카페"), ETC("기타"), PORTAL("포탈 검색");

    private String value;

    AppliedPathEnum(String value) {
        this.value =value;
    }
    public static AppliedPathEnum of(String name) {
        return AppliedPathEnum.valueOf(name);
    }

}
