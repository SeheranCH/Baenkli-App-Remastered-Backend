package ch.tbz.m326.BaenkliApplication.domainModells.address;

import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedDTO;

public class AddressDTO extends ExtendedDTO {

    private String id;

    private String street;

    private String zip;

    private String place;

    public AddressDTO() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public AddressDTO setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getZip() {
        return zip;
    }

    public AddressDTO setZip(String zip) {
        this.zip = zip;
        return this;
    }

    public String getPlace() {
        return place;
    }

    public AddressDTO setPlace(String place) {
        this.place = place;
        return this;
    }
}
