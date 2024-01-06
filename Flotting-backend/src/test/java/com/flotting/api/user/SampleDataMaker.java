package com.flotting.api.user;

import com.flotting.api.user.model.UserDetailRequestDto;
import com.flotting.api.user.model.UserDetailResponseDto;
import com.flotting.api.user.model.UserSimpleRequestDto;
import com.flotting.api.user.model.UserSimpleResponseDto;
import com.flotting.api.user.repository.UserSimpleRepository;
import com.flotting.api.user.service.UserService;
import com.flotting.config.TokenUser;
import com.flotting.domain.UserDetailProfile;
import com.flotting.domain.UserSimpleProfile;
import com.flotting.domain.type.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
public class SampleDataMaker {

    @Autowired
    private UserService userService;

    public void makeUserData() {
        List<String> names = List.of("A", "B", "C", "D", "E", "F", "G");
        List<JobEnum> jobs = List.of(JobEnum.PROFESSIONAL, JobEnum.MID_MAJOR_COMPANY, JobEnum.BUSNINESS, JobEnum.MID_MAJOR_COMPANY, JobEnum.PUBLIC_COMPANY, JobEnum.PROFESSIONAL);
        List<Integer> ages = List.of(1,2,3,4,5,6);
        List<String> phoneNumbers = List.of("0101111", "010333", "010222", "010444", "010555", "010666");

        List<Integer> heights = List.of(1,2,3,4,5,6);
        List<Boolean> smokings = List.of(Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, Boolean.TRUE);
        List<BodyEnum> bodies = List.of(BodyEnum.RELIABLE, BodyEnum.SLIM, BodyEnum.SOLID, BodyEnum.CHUBBY, BodyEnum.MUSCULAR, BodyEnum.NORMAL);
        List<String> charms = List.of("a", "b", "c", "d", "e", "f");
        List<String> detailJobs = List.of("a", "b", "c", "d", "e", "f");
        List<DrinkingEnum> drinkings = List.of(DrinkingEnum.A, DrinkingEnum.B, DrinkingEnum.C, DrinkingEnum.D, DrinkingEnum.A, DrinkingEnum.B);
        List<EducationEnum> educations = List.of(EducationEnum.A, EducationEnum.B, EducationEnum.C, EducationEnum.D, EducationEnum.F, EducationEnum.E);
        List<String> emails = List.of("naver", "daum", "kakao", "google", "never", "gagle");
        List<GradeEnum> grades = List.of(GradeEnum.D, GradeEnum.D, GradeEnum.G, GradeEnum.P, GradeEnum.G, GradeEnum.D);
        List<String> hobbies = List.of("a", "b", "c", "d", "e", "f");
        List<LocationEnum> locations = List.of(LocationEnum.SEOUL_EAST, LocationEnum.GGYEONGGI_EAST, LocationEnum.GGYEONGGI_NORTH, LocationEnum.SEOUL_EAST, LocationEnum.SEOUL_NORTH, LocationEnum.SEOUL_WEST);
        List<String> loveValues = List.of("a", "b", "c", "d", "e", "f");
        List<String> nickNames = List.of("a", "b", "c", "d", "e", "f");
        List<AppliedPathEnum> paths = List.of(AppliedPathEnum.A, AppliedPathEnum.B, AppliedPathEnum.C, AppliedPathEnum.D, AppliedPathEnum.E, AppliedPathEnum.H);
        List<GenderEnum> genders = List.of(GenderEnum.F, GenderEnum.M, GenderEnum.F, GenderEnum.M, GenderEnum.F, GenderEnum.M);
        List<PreferenceEnum> preferences = List.of(PreferenceEnum.AGE, PreferenceEnum.DISTANCE, PreferenceEnum.HEIGHT, PreferenceEnum.JOB, PreferenceEnum.HEIGHT, PreferenceEnum.JOB);
        List<String> preferenceDetails = List.of("a", "b", "c", "d", "e", "f");
        List<String> recommendUserNames = List.of("a", "b", "c", "d", "e", "f");
        List<String> URIs = List.of("a", "b", "c", "d", "e", "f");

        IntStream.range(0, 6).forEach(idx -> {
            UserSimpleRequestDto simpleRequestDto = UserSimpleRequestDto.builder()
                    .name(names.get(idx))
                    .job(jobs.get(idx).name())
                    .age(ages.get(idx))
                    .phoneNumber(phoneNumbers.get(idx))
                    .build();
            UserSimpleResponseDto userSimpleResponseDto = userService.saveSimpleUserInfo(TokenUser.defaultUser(), simpleRequestDto);
            TokenUser savedUser = new TokenUser(userSimpleResponseDto.getUserNo(), userSimpleResponseDto.getName());

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
                    .URI(URIs.get(idx)).build();
            UserDetailResponseDto userDetailResponseDto = userService.saveDetailUserInfo(savedUser, userSimpleResponseDto.getUserNo(), detailRequestDto);
        });
    }
}
