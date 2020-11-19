package ch.tbz.m326.BaenkliApplication.domainModells.rating;

import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends ExtendedJpaRepository<Rating> {
}