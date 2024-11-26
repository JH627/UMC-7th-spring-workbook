package umc.study.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.mapping.MemberMission;
import umc.study.domain.mapping.MissionStatus;
import umc.study.exception.member.MemberHandler;
import umc.study.exception.store.StoreHandler;
import umc.study.repository.MemberMissionRepository.MemberMissionRepository;
import umc.study.repository.MemberRepository.MemberRepository;
import umc.study.repository.MissionRepository.MissionRepository;
import umc.study.web.memberMission.dto.MemberMissionRequestDTO;

@Service
@RequiredArgsConstructor
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {

    private final MemberMissionRepository memberMissionRepository;
    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public MemberMission addMemberMission(MemberMissionRequestDTO.CreateMemberMissionDTO request) {
        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() ->
                        new StoreHandler(ErrorStatus.MISSION_NOT_FOUND)
                );

        Member member = memberRepository.findById(1L)
                .orElseThrow(() ->
                        new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND)
                );

        MemberMission memberMission = MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.CHALLENGING)
                .build();

        return memberMissionRepository.save(memberMission);
    }

    @Override
    public MemberMission completeMemberMission(MemberMissionRequestDTO.UpdateMemberMissionDTO request) {
        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() ->
                        new StoreHandler(ErrorStatus.MISSION_NOT_FOUND)
                );

        Member member = memberRepository.findById(1L)
                .orElseThrow(() ->
                        new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND)
                );

        MemberMission memberMission = memberMissionRepository.findByMissionAndMember(mission, member);
        memberMission.changeStatus(MissionStatus.COMPLETE);
        return memberMissionRepository.save(memberMission);
    }
}
