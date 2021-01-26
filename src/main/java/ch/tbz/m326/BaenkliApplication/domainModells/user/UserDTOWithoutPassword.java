package ch.tbz.m326.BaenkliApplication.domainModells.user;

import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedDTO;
import ch.tbz.m326.BaenkliApplication.domainModells.bench.Bench;

import java.util.List;

public class UserDTOWithoutPassword extends ExtendedDTO {

    private String id;

    private String username;

    private String email;

    private String firstName;

    private String lastName;

    private List<Bench> favoriteBenches;

    public UserDTOWithoutPassword() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public UserDTOWithoutPassword setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getFirstName() {
        return firstName;
    }

    public UserDTOWithoutPassword setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserDTOWithoutPassword setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public List<Bench> getFavoriteBenches() {
        return favoriteBenches;
    }

    public void setFavoriteBenches(List<Bench> favoriteBenches) {
        this.favoriteBenches = favoriteBenches;
    }
}
