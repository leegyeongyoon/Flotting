package com.flotting.api.user.enums;


public enum UserStatusEnum {

    WITHDRAWAL("탈퇴"), DORMANT("휴면"), NORMAL("활성"), FORCED_WITHDRAWAL("강제탈퇴");

    //TODO 휴면, 활성, 강제 탈퇴인 경우 회원정보 지우면 안됨.
    //TODO 탈퇴인 경우 회원정보 모두 삭제
    private String value;

    UserStatusEnum(String value) {
        this.value =value;
    }
    public static UserStatusEnum of(String name) {
        return UserStatusEnum.valueOf(name);
    }

}
