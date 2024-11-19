package umc.study.web.mission.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.time.LocalDate;

public class MissionRequestDTO {

    @Getter
    public static class CreateMissionDTO {
        @NotNull
        private Long storeId;
        @NotNull
        private Integer reward;
        @NotNull
        private LocalDate deadline;
        @Size(min = 5, max = 50)
        private String missionSpec;
    }
}
