package com.flotting.api.manager.controller;

import com.flotting.api.manager.service.ManagerService;
import com.flotting.api.user.model.UserDetailResponseDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "manager API", description = "manager 조회/저장 API")
public class ManagerController {

    private final ManagerService managerService;

    @Operation(summary = "매니저 프로필 승인", description = "1,2차 프로필 매니저 승인")
    @Parameter(name = "u", description = "userDetailRequestDto : 2차 프로필 정보")
    @ApiResponse(responseCode = "200", description = "user수정 성공", content = @Content(schema = @Schema(implementation = UserDetailResponseDto.class)))
    @PutMapping("/approve/user/{detailProfileId}")
    public ResponseEntity approveUserProfile(
                                             @RequestParam(name = "detailProfileId") Long detailProfileId) {
        managerService.approveInfo( detailProfileId);
        return ResponseEntity.ok().build();
    }
}
