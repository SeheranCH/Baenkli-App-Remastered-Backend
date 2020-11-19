package ch.tbz.m326.BaenkliApplication.domainModells.quiet;

import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuietRepository extends ExtendedJpaRepository<Quiet> {
}
