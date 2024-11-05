package umc.study.repository.ReviewRepository;

public interface ReviewRepositoryCustom {
    void createReview(String body, Float score, Long memberId, Long storeId);
}
