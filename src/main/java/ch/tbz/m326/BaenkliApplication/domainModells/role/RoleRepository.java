package ch.tbz.m326.BaenkliApplication.domainModells.role;

import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends ExtendedJpaRepository<Role> {

}

