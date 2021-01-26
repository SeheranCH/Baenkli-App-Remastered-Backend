package ch.tbz.m326.BaenkliApplication.domainModells.user;

import ch.tbz.m326.BaenkliApplication.config.error.BadRequestException;
import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedJpaRepository;
import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedServiceImpl;
import ch.tbz.m326.BaenkliApplication.domainModells.bench.Bench;
import ch.tbz.m326.BaenkliApplication.domainModells.bench.BenchRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends ExtendedServiceImpl<User> implements UserService {

    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private BenchRepository benchRepository;

    public UserServiceImpl(@Qualifier("userRepository") ExtendedJpaRepository<User> repository, BCryptPasswordEncoder bCryptPasswordEncoder, BenchRepository benchRepository) {
        super(repository);
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.benchRepository = benchRepository;
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
    public User findByUsername(String username) {
        return findOrThrow(((UserRepository) repository).findByUsername(username));
    }

    @Override
    public User addToFavoriteBenches(String userId, String benchId, User userToUpdate) {
        Optional<Bench> benchToAdd = benchRepository.findById(benchId);
        Optional<User> optionalUser = repository.findById(userId);
        if (benchToAdd != null && optionalUser != null) {
            optionalUser.get().getFavoriteBenches().add(benchToAdd.get());
            List<Bench> newList = optionalUser.get().getFavoriteBenches().stream().distinct().collect(Collectors.toList());
            optionalUser.get().setFavoriteBenches(newList);
            return updateById(userId, optionalUser.get());
        }
        throw new NoSuchElementException("user don't exist");
    }

    @Override
    public User removeFromFavoriteBenches(String userId, String benchId, User userToUpdate) {
        Optional<Bench> benchToRemove = benchRepository.findById(benchId);
        Optional<User> user = repository.findById(userToUpdate.getId());
        if (benchToRemove != null && user != null) {
            List<Bench> currentFavorites = user.get().getFavoriteBenches().stream().distinct().collect(Collectors.toList());
            if (currentFavorites.remove(benchToRemove.get())) {
                user.get().setFavoriteBenches(currentFavorites);
                return updateById(userId, user.get());
            } else throw new NoSuchElementException("Bench hasn't been able to be removed");
        } else throw new NoSuchElementException("Bench or User don't exist");

    }

    @Override
    public User save(User user) {
        if (user.getPassword() != null) {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        } else {
            String standardPassword = "12345";
            user.setPassword(bCryptPasswordEncoder.encode(standardPassword));
        }
        if (user.getId() == null) {
            user.setEnabled(true);
            user.setLocked(false);
            user.setAccountExpirationDate(LocalDate.now().plusYears(1));
            user.setCredentialsExpirationDate(LocalDate.now().plusYears(1));
        }
        return repository.save(user);
    }

    @Override
    public User updateById(String id, User entity) throws NoSuchElementException, BadRequestException {
        User user = findById(id);
        if (user.getId().equals(entity.getId())) {
            user.setUsername(entity.getUsername());
            user.setEmail(entity.getEmail());
            user.setFirstName(entity.getFirstName());
            user.setLastName(entity.getLastName());
            user.setFavoriteBenches(entity.getFavoriteBenches());
            return repository.save(user);
        } else {
            throw new BadRequestException("Invalid body");
        }
    }

    @PreAuthorize("hasAuthority('USER_SEE')")
    @Override
    public List<User> findAll(){
        return repository.findAll();
    }

}
