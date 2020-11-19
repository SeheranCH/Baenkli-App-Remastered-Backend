package ch.tbz.m326.BaenkliApplication.domainModells.authority;

import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends ExtendedJpaRepository<Authority> {

}
