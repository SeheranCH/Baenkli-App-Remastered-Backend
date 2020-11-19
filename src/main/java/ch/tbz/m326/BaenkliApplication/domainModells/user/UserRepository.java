package ch.tbz.m326.BaenkliApplication.domainModells.user;

import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedJpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends ExtendedJpaRepository<User> {
    @Transactional
    @Query(nativeQuery = true, value = "select * from public.users where email = :email and enabled = true")
    Optional<User> findByEmail(String email);
}