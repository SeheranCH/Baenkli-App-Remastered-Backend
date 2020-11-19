package ch.tbz.m326.BaenkliApplication.domainModells.rating;

import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "rating")
public class Rating extends ExtendedEntity {

    @Column(name = "rating")
    @Min(value = 1)
    @Max(value = 5)
    private double rating;

    public Rating() {
    }

    public double getRating() {
        return rating;
    }

    public Rating setRating(double rating) {
        this.rating = rating;
        return this;
    }
}
