package ch.tbz.m326.BaenkliApplication.domainModells.user;

import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedService;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.persistence.OneToOne;
import java.util.List;

public interface UserService extends UserDetailsService, ExtendedService<User> {
    User findByEmail(String email);

    User findByUsername(String username);
    User addToFavoriteBenches(String userId, String benchId, User userToUpdate);
    User removeFromFavoriteBenches(String userId, String benchId, User userToUpdate);

}
