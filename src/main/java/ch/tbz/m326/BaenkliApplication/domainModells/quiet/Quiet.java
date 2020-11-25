package ch.tbz.m326.BaenkliApplication.domainModells.quiet;

import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "quiet")
public class Quiet extends ExtendedEntity {

    @Column(name = "quiet")
    @Min(value = 1)
    @Max(value = 5)
    private double quiet;

    public Quiet() {
    }

        public double getQuiet() {
            return quiet;
        }

        public Quiet setQuiet(double quiet) {
        this.quiet = quiet;
        return this;
    }
}
