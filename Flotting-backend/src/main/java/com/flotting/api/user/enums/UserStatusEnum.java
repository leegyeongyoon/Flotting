package com.flotting.api.user.enums;


public enum UserStatusEnum {

    STOP("정지"), DORMANT("휴면"), NORMAL("활성");

    private String value;

    UserStatusEnum(String nvalueame) {
        this.value =value;
    }
    public static UserStatusEnum of(String name) {
        return UserStatusEnum.valueOf(name);
    }

}
