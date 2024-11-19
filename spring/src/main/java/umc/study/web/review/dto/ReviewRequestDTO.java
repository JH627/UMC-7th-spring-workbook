package umc.study.web.review.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.study.validation.annotation.ExistStore;

public class ReviewRequestDTO {

    @Getter
    public static class CreateReviewDTO {
        @ExistStore
        private Long storeId;
        @NotNull
        private String body;
        @NotNull
        private Float score;
    }
}
