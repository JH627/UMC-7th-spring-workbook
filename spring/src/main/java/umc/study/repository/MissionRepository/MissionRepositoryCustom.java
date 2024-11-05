package umc.study.repository.MissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.study.domain.Mission;
import umc.study.domain.enums.MissionStatus;

public interface MissionRepositoryCustom {
    Page<Mission> findMissionsByStatus(MissionStatus status, Pageable pageable);
    Page<Mission> findReadyMissionsByRegion(Long regionId, Pageable pageable);
}
