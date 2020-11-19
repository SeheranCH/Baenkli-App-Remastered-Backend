package ch.tbz.m326.BaenkliApplication.domainModells.address;

import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedJpaRepository;
import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl extends ExtendedServiceImpl<Address> implements AddressService {

    public AddressServiceImpl(@Qualifier("addressRepository") ExtendedJpaRepository<Address> repository) {
        super(repository);
    }

}
