package ch.tbz.m326.BaenkliApplication.domainModells.address;

import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends ExtendedJpaRepository<Address> {
}
