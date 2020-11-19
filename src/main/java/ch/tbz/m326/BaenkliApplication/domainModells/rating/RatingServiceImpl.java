package ch.tbz.m326.BaenkliApplication.domainModells.rating;

import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedJpaRepository;
import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl extends ExtendedServiceImpl<Rating> implements RatingService {

    public RatingServiceImpl(@Qualifier("ratingRepository") ExtendedJpaRepository<Rating> repository) {
        super(repository);
    }

}
