package com.flotting.api.user.enums;

public enum JobEnum {

    PROFESSIONAL("전문", 3, 3), MID_MAJOR_COMPANY("중견기업&대기업", 3, 1), FINANCE("금융직", 3, 2),
    PUBLIC_COMPANY("공무원&공기업", 2, 3), EDU("교육직", 2, 3), LAB("연구직", 2, 2), MEDICAL("의료직",2, 2),
    BUSNINESS("사업가", 1, 1), SMALL_COMPANY("중소기업", 1, 1),
    FREELANCER("프리랜서", 0, 1), STUDENT("학생", 0, 2);

    private String name;
    private int maleScore;
    private int femaleScore;


    JobEnum(String name, int maleScore, int femaleScore) {
        this.name = name;
        this.maleScore = maleScore;
        this.femaleScore = femaleScore;
    }

    public int getScore(GenderEnum gender) {
        if(GenderEnum.M.equals(gender)) {
            return this.maleScore;
        } else {
            return this.femaleScore;
        }
    }

    public static JobEnum of(String name) {
        return JobEnum.valueOf(name);
    }

}
