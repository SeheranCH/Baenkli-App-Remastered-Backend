package ch.tbz.m326.BaenkliApplication.domainModells.bench;

import ch.tbz.m326.BaenkliApplication.config.error.BadRequestException;
import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedJpaRepository;
import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedServiceImpl;
import ch.tbz.m326.BaenkliApplication.domainModells.address.Address;
import ch.tbz.m326.BaenkliApplication.domainModells.address.AddressService;
import ch.tbz.m326.BaenkliApplication.domainModells.rating.Rating;
import ch.tbz.m326.BaenkliApplication.domainModells.rating.RatingService;
import ch.tbz.m326.BaenkliApplication.domainModells.user.User;
import ch.tbz.m326.BaenkliApplication.domainModells.user.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
public class BenchServiceImpl extends ExtendedServiceImpl<Bench> implements BenchService {

    private BenchRepository benchRepository;
    private RatingService ratingService;
    private UserService userService;
    private AddressService addressService;

    public BenchServiceImpl(@Qualifier("benchRepository") ExtendedJpaRepository<Bench> repository, BenchRepository benchRepository, RatingService ratingService, UserService userService, AddressService addressService) {
        super(repository);
        this.benchRepository = benchRepository;
        this.ratingService = ratingService;
        this.userService = userService;
        this.addressService = addressService;
    }

    @Override
    public List<Bench> findByAddressId(String id) {
        List<Bench> allBenches = repository.findAll();
        List<Bench> foundByAddress = new ArrayList<>();
        for (int i = 0; i < allBenches.size(); i++) {
            if (allBenches.get(i).getAddress().getId() == id) {
                foundByAddress.add(allBenches.get(i));
            }
        }
        return foundByAddress;
    }

    @Override
    public List<Bench> findByLongitudeLatitude(Double longitude, Double latitude) {
        List<Bench> allBenches = repository.findAll();
        List<Bench> foundByLongitudeLatitude = new ArrayList<>();
        for (int i = 0; i < allBenches.size(); i++) {
            if (allBenches.get(i).getLongitude() == longitude && allBenches.get(i).getLatitude() == latitude) {
                foundByLongitudeLatitude.add(allBenches.get(i));
            }
        }
        return foundByLongitudeLatitude;
    }

    @Override
    public List<Bench> findByUserId(String userId) {
        User user = userService.findById(userId);
        if (user != null) {
            List<Bench> benchesByUser = benchRepository.findAllByUserId(userId);
            return benchesByUser;
        } else {
            throw new BadRequestException("User Id not found");
        }
    }

    @Override
    public Bench checkBenchById(String id) {
        Bench bench = findById(id);
        if (bench == null) {
            throw new NoSuchElementException(String.format("No bench found with id '%s'", id));
        } else {
            return bench;
        }
    }

    @Override
    public List<Bench> getFavoriteBenchesFromUserId(String userId) {
        return ((BenchRepository) repository).getFavoriteBenchesFromUserId(userId);
    }

    @Override
    public Bench addRatingToBench(String benchId, String ratingId) {
        Bench bench = checkBenchById(benchId);
        Rating rating = ratingService.findById(ratingId);
        if (rating == null) {
            throw new NoSuchElementException(String.format("No rating found with id '%s'", ratingId));
        }
        Set<Rating> ratings = bench.getRatings();
        ratings.add(rating);
        bench.setRatings(ratings);
        return repository.save(bench);
    }

    @Override
    public Bench addUserToBench(String benchId, String userId) {
        Bench bench = checkBenchById(benchId);
        User user = userService.findById(userId);
        if (user == null) {
            throw new NoSuchElementException(String.format("No user found with id '%s'", userId));
        }
        bench.setUser(user);
        return repository.save(bench);
    }

    @Override
    public Bench addAddressToBench(String benchId, String addressId) {
        Bench bench = checkBenchById(benchId);
        Address address = addressService.findById(addressId);
        if (address == null) {
            throw new NoSuchElementException(String.format("No address found with id '%s'", addressId));
        }
        bench.setAddress(address);
        return repository.save(bench);
    }
}
