package umc.study.repository.ReviewRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.*;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {

    private final EntityManager em;
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public void createReview(String body, Float score, Long memberId, Long storeId) {
        QMember qMember = QMember.member;
        QStore qStore = QStore.store;

        Member member = jpaQueryFactory
                .selectFrom(qMember)
                .where(qMember.id.eq(memberId))
                .fetchOne();

        Store store = jpaQueryFactory
                .selectFrom(qStore)
                .where(qStore.id.eq(storeId))
                .fetchOne();

        Review review = Review.builder()
                .body(body)
                .score(score)
                .member(member)
                .store(store)
                .build();

        em.persist(review);
    }
}
