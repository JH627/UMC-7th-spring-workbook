package umc.study.repository.MissionRepository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import umc.study.domain.Mission;
import umc.study.domain.QMission;
import umc.study.domain.QStore;
import umc.study.domain.enums.MissionStatus;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QMission mission = QMission.mission;
    private final QStore store = QStore.store;

    @Override
    public Page<Mission> findMissionsByStatus(MissionStatus status, Pageable pageable) {
        List<Mission> missions = jpaQueryFactory
                .selectFrom(mission)
                .where(statusEqual(status))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(mission.id.asc())
                .fetch();

        long total = jpaQueryFactory
                .selectFrom(mission)
                .where(statusEqual(status))
                .fetchCount();

        return new PageImpl<>(missions, pageable, total);
    }

    @Override
    public Page<Mission> findReadyMissionsByRegion(Long regionId, Pageable pageable) {
        List<Mission> missions = jpaQueryFactory
                .selectFrom(mission)
                .join(mission.store, store)
                .where(statusEqual(MissionStatus.READY)
                        .and(store.region.id.eq(regionId)))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(mission.deadline.asc())
                .fetch();

        long total = jpaQueryFactory
                .selectFrom(mission)
                .join(mission.store, store)
                .where(statusEqual(MissionStatus.READY)
                        .and(store.region.id.eq(regionId)))
                .fetchCount();

        return new PageImpl<>(missions, pageable, total);
    }

    private BooleanExpression statusEqual(MissionStatus status) {
        return mission.status.eq(status);
    }
}
