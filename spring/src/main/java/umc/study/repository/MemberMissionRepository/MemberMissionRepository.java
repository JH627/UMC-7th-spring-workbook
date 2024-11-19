package umc.study.repository.MemberMissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.mapping.MemberMission;
import umc.study.domain.mapping.MissionStatus;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    boolean existsByMemberIdAndMissionIdAndStatus(long memberId, Long missionId, MissionStatus missionStatus);
}
