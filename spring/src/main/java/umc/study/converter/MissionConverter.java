package umc.study.converter;

import umc.study.domain.Mission;
import umc.study.web.mission.dto.MissionResponseDTO;

public class MissionConverter {
    public static MissionResponseDTO.CreateResultDTO toCreateResultDTO(Mission mission) {
        return MissionResponseDTO.CreateResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(mission.getCreatedAt())
                .build();
    }
}
