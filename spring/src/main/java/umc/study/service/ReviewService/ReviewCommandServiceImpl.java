package umc.study.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.exception.member.MemberHandler;
import umc.study.exception.store.StoreHandler;
import umc.study.repository.MemberRepository.MemberRepository;
import umc.study.repository.ReviewRepository.ReviewRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.web.review.dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Review create(ReviewRequestDTO.CreateReviewDTO request) {
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() ->
                    new StoreHandler(ErrorStatus.STORE_NOT_FOUND)
                );

        // 1로 하드코딩
        Member member = memberRepository.findById(1L)
                .orElseThrow(() ->
                        new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND)
                );

        Review review = Review.builder()
                .body(request.getBody())
                .score(request.getScore())
                .store(store)
                .member(member)
                .build();

        return reviewRepository.save(review);
    }
}
