package umc.study.service.StoreService;

import umc.study.domain.Store;
import umc.study.web.store.dto.StoreRequestDTO;

public interface StoreCommandService {
    Store create(StoreRequestDTO.CreateStoreDTO request);
}
