package ch.tbz.m326.BaenkliApplication.domainModells.bench;

import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedDTO;
import ch.tbz.m326.BaenkliApplication.domainModells.address.Address;
import ch.tbz.m326.BaenkliApplication.domainModells.quiet.Quiet;
import ch.tbz.m326.BaenkliApplication.domainModells.rating.Rating;
import ch.tbz.m326.BaenkliApplication.domainModells.user.User;

import java.util.Set;

public class BenchDTO extends ExtendedDTO {

    private String id;

    private String title;

    private String description;

    private Double longitude;

    private Double latitude;

    private int amountBenches;

    private int amountFirePlaces;

    private int amountTrashCans;

    private double distanceToNextShop;

    private String directions;

    private boolean hasMeadow;

    private boolean isLocationOnWater;

    private Address address;

    private User user;

    private Set<Rating> ratings;

    private Set<Quiet> quiets;

    public BenchDTO() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public BenchDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public BenchDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getLongitude() {
        return longitude;
    }

    public BenchDTO setLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    public Double getLatitude() {
        return latitude;
    }

    public BenchDTO setLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public int getAmountBenches() {
        return amountBenches;
    }

    public BenchDTO setAmountBenches(int amountBenches) {
        this.amountBenches = amountBenches;
        return this;
    }

    public int getAmountFirePlaces() {
        return amountFirePlaces;
    }

    public BenchDTO setAmountFirePlaces(int amountFirePlaces) {
        this.amountFirePlaces = amountFirePlaces;
        return this;
    }

    public int getAmountTrashCans() {
        return amountTrashCans;
    }

    public BenchDTO setAmountTrashCans(int amountTrashCans) {
        this.amountTrashCans = amountTrashCans;
        return this;
    }

    public double getDistanceToNextShop() {
        return distanceToNextShop;
    }

    public BenchDTO setDistanceToNextShop(double distanceToNextShop) {
        this.distanceToNextShop = distanceToNextShop;
        return this;
    }

    public String getDirections() {
        return directions;
    }

    public BenchDTO setDirections(String directions) {
        this.directions = directions;
        return this;
    }

    public boolean isHasMeadow() {
        return hasMeadow;
    }

    public BenchDTO setHasMeadow(boolean hasMeadow) {
        this.hasMeadow = hasMeadow;
        return this;
    }

    public boolean isLocationOnWater() {
        return isLocationOnWater;
    }

    public BenchDTO setLocationOnWater(boolean locationOnWater) {
        isLocationOnWater = locationOnWater;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public BenchDTO setAddress(Address address) {
        this.address = address;
        return this;
    }

    public User getUser() {
        return user;
    }

    public BenchDTO setUser(User user) {
        this.user = user;
        return this;
    }

    public Set<Rating> getRatings() {
        return ratings;
    }

    public BenchDTO setRatings(Set<Rating> ratings) {
        this.ratings = ratings;
        return this;
    }

    public Set<Quiet> getQuiets() {
        return quiets;
    }

    public BenchDTO setQuiets(Set<Quiet> quiets) {
        this.quiets = quiets;
        return this;
    }
}
