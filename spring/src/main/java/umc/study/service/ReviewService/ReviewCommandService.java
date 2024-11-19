package umc.study.service.ReviewService;

import umc.study.domain.Review;
import umc.study.web.review.dto.ReviewRequestDTO;

public interface ReviewCommandService {
    Review create(ReviewRequestDTO.CreateReviewDTO request);
}
