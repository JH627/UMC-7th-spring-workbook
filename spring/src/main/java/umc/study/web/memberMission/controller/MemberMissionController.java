package umc.study.web.memberMission.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MemberMissionConverter;
import umc.study.domain.mapping.MemberMission;
import umc.study.service.MemberMissionService.MemberMissionCommandService;
import umc.study.web.memberMission.dto.MemberMissionRequestDTO;
import umc.study.web.memberMission.dto.MemberMissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member-missions")
public class MemberMissionController {

    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/")
    public ApiResponse<MemberMissionResponseDTO.CreateResultDTO> addMemberMission(@RequestBody @Valid MemberMissionRequestDTO.CreateMemberMissionDTO request){
        MemberMission memberMission = memberMissionCommandService.addMemberMission(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toCreateResultDTO(memberMission));
    }
}
