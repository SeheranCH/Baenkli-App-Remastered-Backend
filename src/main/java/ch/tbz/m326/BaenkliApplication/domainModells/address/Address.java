package ch.tbz.m326.BaenkliApplication.domainModells.address;

import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address extends ExtendedEntity {

    @Column(name = "street")
    private String street;

    @Column(name = "zip")
    private String zip;

    @Column(name = "place")
    private String place;

    public Address() {
    }

    public String getStreet() {
        return street;
    }

    public Address setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getZip() {
        return zip;
    }

    public Address setZip(String zip) {
        this.zip = zip;
        return this;
    }

    public String getPlace() {
        return place;
    }

    public Address setPlace(String place) {
        this.place = place;
        return this;
    }

}
