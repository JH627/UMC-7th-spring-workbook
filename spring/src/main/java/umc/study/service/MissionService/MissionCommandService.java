package umc.study.service.MissionService;

import umc.study.domain.Mission;
import umc.study.web.mission.dto.MissionRequestDTO;

public interface MissionCommandService {
    Mission create(MissionRequestDTO.CreateMissionDTO request);
}
