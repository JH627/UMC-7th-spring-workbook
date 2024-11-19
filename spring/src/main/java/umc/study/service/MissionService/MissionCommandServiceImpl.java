package umc.study.service.MissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.domain.enums.MissionStatus;
import umc.study.exception.store.StoreHandler;
import umc.study.repository.MissionRepository.MissionRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.web.mission.dto.MissionRequestDTO;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;

    @Override
    @Transactional
    public Mission create(MissionRequestDTO.CreateMissionDTO request) {
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() ->
                        new StoreHandler(ErrorStatus.STORE_NOT_FOUND)
                );

        Mission mission = Mission.builder()
                .reward(request.getReward())
                .deadline(request.getDeadline())
                .status(MissionStatus.READY)
                .missionSpec(request.getMissionSpec())
                .store(store)
                .build();

        return missionRepository.save(mission);
    }
}
