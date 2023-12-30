package com.flotting.domain.type;

public enum MatchingProcessEnum {

    SUCCESS("성공"), PROCESS("진행중"), REFUND("환불");

    private String value;

    MatchingProcessEnum(String value) {
        this.value = value;
    }
    public static MatchingProcessEnum of(String name) {
        return MatchingProcessEnum.valueOf(name);
    }

}
