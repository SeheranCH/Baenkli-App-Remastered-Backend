package ch.tbz.m326.BaenkliApplication.domainModells.quiet;

import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedJpaRepository;
import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class QuietServiceImpl extends ExtendedServiceImpl<Quiet> implements QuietService {

    public QuietServiceImpl(@Qualifier("quietRepository") ExtendedJpaRepository<Quiet> repository) {
        super(repository);
    }

}
