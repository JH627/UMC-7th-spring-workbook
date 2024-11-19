package umc.study.web.store.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

public class StoreRequestDTO {

    @Getter
    public static class CreateStoreDTO {
        @Size(min = 1, max = 50)
        private String name;

        @Size(min = 5, max = 50)
        private String address;

        @NotNull
        private Long regionId;
    }
}
