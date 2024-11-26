package umc.study.web.memberMission.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.study.validation.annotation.RunningMission;

public class MemberMissionRequestDTO {
    @Getter
    public static class CreateMemberMissionDTO {
        @NotNull
        @RunningMission
        private Long missionId;
    }

    @Getter
    public static class UpdateMemberMissionDTO {
        @NotNull
        private Long missionId;
    }

}
