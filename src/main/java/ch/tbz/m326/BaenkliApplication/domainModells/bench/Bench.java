package ch.tbz.m326.BaenkliApplication.domainModells.bench;

import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedEntity;
import ch.tbz.m326.BaenkliApplication.domainModells.address.Address;
import ch.tbz.m326.BaenkliApplication.domainModells.rating.Rating;
import ch.tbz.m326.BaenkliApplication.domainModells.user.User;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "bench")
public class Bench extends ExtendedEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "amountBenches")
    private int amountBenches;

    @Column(name = "amountFirePlaces")
    private int amountFirePlaces;

    @Column(name = "amountTrashCans")
    private int amountTrashCans;

    @Column(name = "distanceToNextShop")
    private double distanceToNextShop;

    @Column(name = "directions")
    private String directions;

    @Column(name = "hasMeadow")
    private boolean hasMeadow;

    @Column(name = "isLocationOnWater")
    private boolean isLocationOnWater;

    @Column(name = "quietness")
    @Min(value = 1)
    @Max(value = 5)
    private double quietness;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Address address;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Rating> ratings;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(
            name = "users_benches",
            joinColumns = @JoinColumn(name = "bench_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> favorites;

    public Bench() {}

    public String getTitle() {
        return title;
    }

    public Bench setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Bench setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Bench setLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Bench setLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    public int getAmountBenches() {
        return amountBenches;
    }

    public Bench setAmountBenches(int amountBenches) {
        this.amountBenches = amountBenches;
        return this;
    }

    public int getAmountFirePlaces() {
        return amountFirePlaces;
    }

    public Bench setAmountFirePlaces(int amountFirePlaces) {
        this.amountFirePlaces = amountFirePlaces;
        return this;
    }

    public int getAmountTrashCans() {
        return amountTrashCans;
    }

    public Bench setAmountTrashCans(int amountTrashCans) {
        this.amountTrashCans = amountTrashCans;
        return this;
    }

    public double getDistanceToNextShop() {
        return distanceToNextShop;
    }

    public Bench setDistanceToNextShop(double distanceToNextShop) {
        this.distanceToNextShop = distanceToNextShop;
        return this;
    }

    public String getDirections() {
        return directions;
    }

    public Bench setDirections(String directions) {
        this.directions = directions;
        return this;
    }

    public boolean isHasMeadow() {
        return hasMeadow;
    }

    public Bench setHasMeadow(boolean hasMeadow) {
        this.hasMeadow = hasMeadow;
        return this;
    }

    public boolean isLocationOnWater() {
        return isLocationOnWater;
    }

    public Bench setLocationOnWater(boolean locationOnWater) {
        isLocationOnWater = locationOnWater;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public Bench setAddress(Address address) {
        this.address = address;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Bench setUser(User user) {
        this.user = user;
        return this;
    }

    public Set<Rating> getRatings() {
        return ratings;
    }

    public Bench setRatings(Set<Rating> ratings) {
        this.ratings = ratings;
        return this;
    }

    public double getQuietness() {
        return quietness;
    }

    public void setQuietness(double quietness) {
        this.quietness = quietness;
    }

    public List<User> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<User> favorites) {
        this.favorites = favorites;
    }
}
