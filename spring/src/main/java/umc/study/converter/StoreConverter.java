package umc.study.converter;

import umc.study.domain.Store;
import umc.study.web.store.dto.StoreResponseDTO;

public class StoreConverter {

    public static StoreResponseDTO.CreateResultDTO toCreateResultDTO(Store store) {
        return StoreResponseDTO.CreateResultDTO.builder()
                .storeId(store.getId())
                .createdAt(store.getCreatedAt())
                .build();

    }
}
