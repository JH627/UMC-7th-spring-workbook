package umc.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.exception.region.RegionCategoryHandler;
import umc.study.repository.RegionRepository.RegionRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.web.store.dto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public Store create(StoreRequestDTO.CreateStoreDTO request) {
        Region region = regionRepository.findById(request.getRegionId())
                .orElseThrow(() ->
                        new RegionCategoryHandler(ErrorStatus.REGION_NOT_FOUND)
                );

        Store store = Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .region(region)
                .build();

        return storeRepository.save(store);
    }
}
