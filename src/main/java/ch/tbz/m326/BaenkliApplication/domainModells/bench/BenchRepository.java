package ch.tbz.m326.BaenkliApplication.domainModells.bench;

import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedJpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BenchRepository extends ExtendedJpaRepository<Bench> {

    List<Bench> findAllByUserId(String id);

    @Transactional
    @Query(nativeQuery = true, value = "insert into public.bench_ratings (bench_id, ratings_id) values (:benchId, :ratingId)")
    void insertRatingToBench (@Param(value = "benchId") String benchId,  @Param(value = "ratingId") String ratingId);

    @Query(value = "SELECT * FROM public.bench RIGHT JOIN public.users_benches " +
            "ON public.bench.id = public.users_benches.benches_id " +
            "WHERE public.users_benches.users_id = :userId ",
    nativeQuery = true)
    List<Bench> getFavoriteBenchesFromUserId(@Param("userId") String userId);
}
