package umc.study.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Mission;
import umc.study.domain.mapping.MissionStatus;
import umc.study.repository.MemberMissionRepository.MemberMissionRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MemberMissionRepository memberMissionRepository;

    public Page<Mission> getChallengingMissionsForMember(Long memberId, int page) {
        return memberMissionRepository.findChallengingMissionsByMemberId(memberId, MissionStatus.CHALLENGING, PageRequest.of(page, 10));
    }
}
