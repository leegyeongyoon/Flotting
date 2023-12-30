package com.flotting.api.user.controller;


import com.flotting.api.user.model.UserDetailResponseDto;
import com.flotting.api.user.model.UserFilterRequestDto;
import com.flotting.api.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "user API", description = "user 조회/저장 API")
public class UserController extends ApiController {

    private final UserService userService;

    @Operation(summary = "filter에 해당하는 user조회", description = "성별, 체형, 신장, 휴면, 거주지, 나이, 등급, 직업, 흡연 필터링")
    @Parameter(name = "userFilterRequestDto", description = "requestParam : 성별, 체형, 신장, 휴면, 거주지, 나이, 등급, 직업, 흡연")
    @ApiResponse(responseCode = "200", description = "user조회 성공", content = @Content(schema = @Schema(implementation = UserDetailResponseDto.class)))
    @GetMapping("/user/filter")
    public List<UserDetailResponseDto> getUsersByFilter(TokenUser tokenUser, @ModelAttribute UserFilterRequestDto userFilterRequestDto) {
        List<UserDetailResponseDto> usersByFilter = userService.getUsersByFilter(userFilterRequestDto);
        return usersByFilter;
    }


}
