package ch.tbz.m326.BaenkliApplication.domainModells.bench;

import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedService;

import java.util.List;

public interface BenchService extends ExtendedService<Bench> {

    List<Bench> findByAddressId (String id);

    List<Bench> findByLongitudeLatitude (Double longitude, Double latitude);

    Bench addRatingToBench (String benchId, String ratingId);

    //Bench addQuietToBench (String benchId, String quietId);

    Bench addUserToBench (String benchId, String userId);

    Bench addAddressToBench (String benchId, String addressId);

    Bench checkBenchById (String id);
}
