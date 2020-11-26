package ch.tbz.m326.BaenkliApplication.domainModells.user;

import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedJpaRepository;
import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl extends ExtendedServiceImpl<User> implements UserService {

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(@Qualifier("userRepository") ExtendedJpaRepository<User> repository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        super(repository);
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    /**
     * Actually load User by Email
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try {
            return new UserDetailsImpl(findByEmail(email));
        } catch (NoSuchElementException e) {
            throw new UsernameNotFoundException(e.getMessage());
        }
    }

    @Override
    public User findByEmail(String email) {
        return findOrThrow(((UserRepository) repository).findByEmail(email));
    }

    @Override
    public User save(User user) {
        if (user.getPassword() != null) {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        } else {
            String standardPassword = "12345";
            user.setPassword(bCryptPasswordEncoder.encode(standardPassword));
        }
        user.setEnabled(true);
        user.setLocked(false);
        user.setAccountExpirationDate(LocalDate.now().plusYears(1));
        user.setCredentialsExpirationDate(LocalDate.now().plusYears(1));
        return repository.save(user);
    }
}
