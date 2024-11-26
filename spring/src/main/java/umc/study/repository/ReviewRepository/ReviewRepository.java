package umc.study.repository.ReviewRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.Store;

public interface ReviewRepository extends JpaRepository<Review, Integer>, ReviewRepositoryCustom {
    Page<Review> findAllByStore(Store store, PageRequest pageRequest);
    Page<Review> findAllByMember(Member member, PageRequest pageRequest);
}
