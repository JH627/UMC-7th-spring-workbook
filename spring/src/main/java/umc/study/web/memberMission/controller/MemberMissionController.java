package umc.study.web.memberMission.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MemberMissionConverter;
import umc.study.converter.StoreConverter;
import umc.study.domain.Mission;
import umc.study.domain.mapping.MemberMission;
import umc.study.service.MemberMissionService.MemberMissionCommandService;
import umc.study.service.MissionService.MissionQueryService;
import umc.study.validation.annotation.CheckPage;
import umc.study.web.memberMission.dto.MemberMissionRequestDTO;
import umc.study.web.memberMission.dto.MemberMissionResponseDTO;
import umc.study.web.store.dto.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/member-missions")
public class MemberMissionController {

    private final MemberMissionCommandService memberMissionCommandService;
    private final MissionQueryService missionQueryService;

    @PostMapping
    public ApiResponse<MemberMissionResponseDTO.CreateResultDTO> addMemberMission(@RequestBody @Valid MemberMissionRequestDTO.CreateMemberMissionDTO request){
        MemberMission memberMission = memberMissionCommandService.addMemberMission(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toCreateResultDTO(memberMission));
    }

    @GetMapping
    @Operation(summary = "내가 진행 중인 미션 목록 조회 API",description = "내가 진행 중인 미션 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "AUTH003", description = "access 토큰을 주세요!",
                    content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "AUTH004", description = "access 토큰 만료",
                    content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "AUTH006", description = "access 토큰 모양이 이상함",
                    content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "page", description = "페이지 번호를 입력해주세요 (1 이상)")
    })
    public ApiResponse<StoreResponseDTO.MissionPreViewListDTO> getMemberMissionList(
            @CheckPage @RequestParam(name = "page") Integer page) {
        Page<Mission> missionList = missionQueryService.getChallengingMissionsForMember(1L, page - 1);
        return ApiResponse.onSuccess(StoreConverter.missionPreViewListDTO(missionList));
    }
}
