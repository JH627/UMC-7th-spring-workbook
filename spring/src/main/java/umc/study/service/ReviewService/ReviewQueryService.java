package umc.study.service.ReviewService;

import org.springframework.data.domain.Page;
import umc.study.domain.Review;

public interface ReviewQueryService {
    Page<Review> getReviewsByMemberId(long memberId, Integer page);
}
