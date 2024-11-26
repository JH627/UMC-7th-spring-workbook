package umc.study.converter;

import umc.study.domain.mapping.MemberMission;
import umc.study.web.memberMission.dto.MemberMissionResponseDTO;

public class MemberMissionConverter {
    public static MemberMissionResponseDTO.CreateResultDTO toCreateResultDTO(MemberMission mission){
        return MemberMissionResponseDTO.CreateResultDTO.builder()
                .memberMissionId(mission.getId())
                .createdAt(mission.getCreatedAt())
                .build();
    }

    public static MemberMissionResponseDTO.MemberMissionPreviewDTO toMemberMissionPreviewDTO(MemberMission mission) {
        return MemberMissionResponseDTO.MemberMissionPreviewDTO.builder()
                .memberMissionId(mission.getId())
                .status(mission.getStatus().name())
                .createdAt(mission.getCreatedAt())
                .build();
    }
}
