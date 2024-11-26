package umc.study.service.MemberMissionService;

import umc.study.domain.mapping.MemberMission;
import umc.study.web.memberMission.dto.MemberMissionRequestDTO;

public interface MemberMissionCommandService {
    MemberMission addMemberMission(MemberMissionRequestDTO.CreateMemberMissionDTO request);

    MemberMission completeMemberMission(MemberMissionRequestDTO.UpdateMemberMissionDTO request);
}
