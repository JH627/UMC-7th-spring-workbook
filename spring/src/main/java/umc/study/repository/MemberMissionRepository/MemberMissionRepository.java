package umc.study.repository.MemberMissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.mapping.MemberMission;
import umc.study.domain.mapping.MissionStatus;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    boolean existsByMemberIdAndMissionIdAndStatus(long memberId, Long missionId, MissionStatus missionStatus);
    @Query("SELECT mm.mission " +
            "FROM MemberMission mm " +
            "WHERE mm.member.id = :memberId AND mm.status = :status")
    Page<Mission> findChallengingMissionsByMemberId(@Param("memberId") Long memberId,
                                                    @Param("status") MissionStatus status,
                                                    Pageable pageable);

    MemberMission findByMissionAndMember(Mission mission, Member member);
}
