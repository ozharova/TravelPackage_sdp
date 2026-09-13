/**
 * The Product: an immutable travel package.
 * Instances can only be created through {@link TravelPackageBuilder},
 * which guarantees every package it hands out is in a valid state.
 */
public final class TravelPackage {

    private final String destination;
    private final String hotel;
    private final int days;
    private final String transport;
    private final boolean mealsIncluded;
    private final boolean insuranceIncluded;
    private final boolean guideIncluded;

    TravelPackage(TravelPackageBuilder builder) {
        this.destination = builder.destination;
        this.hotel = builder.hotel;
        this.days = builder.days;
        this.transport = builder.transport;
        this.mealsIncluded = builder.mealsIncluded;
        this.insuranceIncluded = builder.insuranceIncluded;
        this.guideIncluded = builder.guideIncluded;
    }

    public String getDestination() {
        return destination;
    }

    public String getHotel() {
        return hotel;
    }

    public int getDays() {
        return days;
    }

    public String getTransport() {
        return transport;
    }

    public boolean hasMeals() {
        return mealsIncluded;
    }

    public boolean hasInsurance() {
        return insuranceIncluded;
    }

    public boolean hasGuide() {
        return guideIncluded;
    }

    @Override
    public String toString() {
        return "TravelPackage{" +
                "destination='" + destination + '\'' +
                ", hotel='" + hotel + '\'' +
                ", days=" + days +
                ", transport='" + transport + '\'' +
                ", mealsIncluded=" + mealsIncluded +
                ", insuranceIncluded=" + insuranceIncluded +
                ", guideIncluded=" + guideIncluded +
                '}';
    }
}
