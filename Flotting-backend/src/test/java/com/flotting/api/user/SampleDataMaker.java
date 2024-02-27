package com.flotting.api.user;

import com.flotting.api.user.enums.*;
import com.flotting.api.user.model.*;
import com.flotting.api.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
public class SampleDataMaker {

    @Autowired
    private UserService userService;

    public List<UserResponseDto> makeUserData() {
        List<UserResponseDto> result = new ArrayList();
        List<String> names = List.of("A", "B", "C", "D", "E", "F", "G");
        List<JobEnum> jobs = List.of(JobEnum.PROFESSIONAL, JobEnum.MID_MAJOR_COMPANY, JobEnum.BUSNINESS, JobEnum.MID_MAJOR_COMPANY, JobEnum.PUBLIC_COMPANY, JobEnum.PROFESSIONAL);
        List<Integer> ages = List.of(1,18,3,4,5,6);
        List<String> phoneNumbers = List.of("0101111", "010333", "010222", "010444", "010555", "010666");
        List<Integer> heights = List.of(1,2,180,4,5,6);
        List<Boolean> smokings = List.of(Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE);
        List<BodyEnum> bodies = List.of(BodyEnum.RELIABLE, BodyEnum.SLIM, BodyEnum.SOLID, BodyEnum.CHUBBY, BodyEnum.MUSCULAR, BodyEnum.NORMAL);
        List<String> charms = List.of("a", "b", "c", "d", "e", "f");
        List<String> detailJobs = List.of("a", "b", "c", "d", "e", "f");
        List<DrinkingEnum> drinkings = List.of(DrinkingEnum.ONE_WEEK, DrinkingEnum.THREE_WEEK, DrinkingEnum.TWO_WEEK, DrinkingEnum.ONE_WEEK, DrinkingEnum.TWO_WEEK, DrinkingEnum.THREE_WEEK);
        List<EducationEnum> educations = List.of(EducationEnum.COLLEGE_ACADEMY_ATTENDING, EducationEnum.COLLEGE_ATTENDING, EducationEnum.JUNIOR_COLLEGE_ATTENDING, EducationEnum.COLLEGE_GRADUATION, EducationEnum.JUNIOR_COLLEGE_GRADUATION, EducationEnum.HIGH_SCHOOL_GRADUATION);
        List<String> emails = List.of("naver", "daum", "kakao", "google", "never", "gagle");
        List<GradeEnum> grades = List.of(GradeEnum.D, GradeEnum.D, GradeEnum.G, GradeEnum.P, GradeEnum.G, GradeEnum.D);
        List<String> hobbies = List.of("a", "b", "c", "d", "e", "f");
        List<LocationEnum> locations = List.of(LocationEnum.GGYEONGGI_EAST, LocationEnum.GGYEONGGI_EAST, LocationEnum.GGYEONGGI_EAST, LocationEnum.SEOUL_EAST, LocationEnum.SEOUL_NORTH, LocationEnum.SEOUL_WEST);
        List<String> loveValues = List.of("a", "b", "c", "d", "e", "f");
        List<String> nickNames = List.of("a", "b", "c", "d", "e", "f");
        List<AppliedPathEnum> paths = List.of(AppliedPathEnum.ETC, AppliedPathEnum.FRIP, AppliedPathEnum.INSTA, AppliedPathEnum.MOONTO, AppliedPathEnum.NAVER, AppliedPathEnum.RECOMMEND);
        List<GenderEnum> genders = List.of(GenderEnum.F, GenderEnum.M, GenderEnum.F, GenderEnum.M, GenderEnum.F, GenderEnum.M);
        List<PreferenceEnum> preferences = List.of(PreferenceEnum.AGE, PreferenceEnum.DISTANCE, PreferenceEnum.HEIGHT, PreferenceEnum.JOB, PreferenceEnum.HEIGHT, PreferenceEnum.JOB);
        List<List<String>> preferenceValues = List.of(List.of("18","19"), List.of(LocationEnum.SEOUL_EAST.name(), LocationEnum.GGYEONGGI_EAST.name()), List.of("180"), List.of(JobEnum.BUSNINESS.name()), List.of("170"), List.of(JobEnum.PROFESSIONAL.name()));
        List<String> preferenceDetails = List.of("a", "b", "c", "d", "e", "f");
        List<String> recommendUserNames = List.of("a", "b", "c", "d", "e", "f");
        List<String> URIs = List.of("a", "b", "c", "d", "e", "f");
        List<Integer> totalScores = List.of(100,100,45,43,23,12);
        List<Integer> faceScores = List.of(1,1,1,1,1,1);

        IntStream.range(0, 6).forEach(idx -> {
            UserSimpleRequestDto simpleRequestDto = UserSimpleRequestDto.builder()
                    .name(names.get(idx))
                    .job(jobs.get(idx).name())
                    .age(ages.get(idx))
                    .phoneNumber(phoneNumbers.get(idx))
                    .password("1234")
                    .build();
            UserSimpleResponseDto userSimpleResponseDto = userService.saveSimpleUserInfo( simpleRequestDto);

            UserDetailRequestDto detailRequestDto = UserDetailRequestDto.builder()
                    .height(heights.get(idx))
                    .smoking(smokings.get(idx))
                    .body(bodies.get(idx).name())
                    .charm(charms.get(idx))
                    .detailJob(detailJobs.get(idx))
                    .drinking(drinkings.get(idx).name())
                    .education(educations.get(idx).name())
                    .email(emails.get(idx))
                    .grade(grades.get(idx).name())
                    .hobby(hobbies.get(idx))
                    .location(locations.get(idx).name())
                    .loveValues(loveValues.get(idx))
                    .nickName(nickNames.get(idx))
                    .path(paths.get(idx).name())
                    .gender(genders.get(idx).name())
                    .preference(preferences.get(idx).name())
                    .preferenceDetail(preferenceDetails.get(idx))
                    .recommendUserName(recommendUserNames.get(idx))
                    .URI(URIs.get(idx))
                    .preferenceValue(preferenceValues.get(idx))
                    .totalScore(totalScores.get(idx))
                    .faceScore(faceScores.get(idx))
                    .build();
            UserDetailResponseDto userDetailResponseDto = userService.saveDetailUserInfo(userSimpleResponseDto.getUserNo(), detailRequestDto);
            result.add(new UserResponseDto(userSimpleResponseDto, userDetailResponseDto));
        });
        return result;
    }
}
