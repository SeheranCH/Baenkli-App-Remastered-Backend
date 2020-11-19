package ch.tbz.m326.BaenkliApplication.domainModells.bench;

import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedJpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BenchRepository extends ExtendedJpaRepository<Bench> {

    @Transactional
    @Query(nativeQuery = true, value = "insert into public.bench_ratings (bench_id, ratings_id) values (:benchId, :ratingId)")
    void insertRatingToBench (@Param(value = "benchId") String benchId,  @Param(value = "ratingId") String ratingId);
}
