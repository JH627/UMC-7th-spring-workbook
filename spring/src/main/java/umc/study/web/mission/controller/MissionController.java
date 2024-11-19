package umc.study.web.mission.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MissionConverter;
import umc.study.domain.Mission;
import umc.study.service.MissionService.MissionCommandService;
import umc.study.web.mission.dto.MissionRequestDTO;
import umc.study.web.mission.dto.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/")
    public ApiResponse<MissionResponseDTO.CreateResultDTO> createMission(@RequestBody @Valid MissionRequestDTO.CreateMissionDTO request){
        Mission mission = missionCommandService.create(request);
        return ApiResponse.onSuccess(MissionConverter.toCreateResultDTO(mission));
    }
}
