package ch.tbz.m326.BaenkliApplication.domainModells.rating;

import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedDTO;

public class RatingDTO extends ExtendedDTO {

    private String id;

    private double rating;

    public RatingDTO() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getRating() {
        return rating;
    }

    public RatingDTO setRating(double rating) {
        this.rating = rating;
        return this;
    }
}
