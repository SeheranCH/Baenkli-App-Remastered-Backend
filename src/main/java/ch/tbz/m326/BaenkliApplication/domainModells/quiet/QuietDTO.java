package ch.tbz.m326.BaenkliApplication.domainModells.quiet;

import ch.tbz.m326.BaenkliApplication.config.generic.ExtendedDTO;

public class QuietDTO extends ExtendedDTO {

    private String id;

    private double quiet;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getQuiet() {
        return quiet;
    }

    public QuietDTO setQuiet(double quiet) {
        this.quiet = quiet;
        return this;
    }
}
