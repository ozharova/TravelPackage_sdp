/**
 * Builder for {@link TravelPackage}.
 * Lets a client assemble a package step by step through a fluent API,
 * then validates the accumulated state before producing the product.
 */
public class TravelPackageBuilder {

    private static final int MIN_DAYS = 1;
    private static final int MAX_DAYS = 60;

    String destination;
    String hotel;
    int days;
    String transport;
    boolean mealsIncluded;
    boolean insuranceIncluded;
    boolean guideIncluded;

    public TravelPackageBuilder destination(String destination) {
        this.destination = destination;
        return this;
    }

    public TravelPackageBuilder hotel(String hotel) {
        this.hotel = hotel;
        return this;
    }

    public TravelPackageBuilder days(int days) {
        this.days = days;
        return this;
    }

    public TravelPackageBuilder transport(String transport) {
        this.transport = transport;
        return this;
    }

    public TravelPackageBuilder withMeals() {
        this.mealsIncluded = true;
        return this;
    }

    public TravelPackageBuilder withInsurance() {
        this.insuranceIncluded = true;
        return this;
    }

    public TravelPackageBuilder withGuide() {
        this.guideIncluded = true;
        return this;
    }

    public TravelPackage build() {
        validate();
        return new TravelPackage(this);
    }

    private void validate() {
        if (destination == null || destination.isBlank()) {
            throw new IllegalStateException("Destination must be set before building a travel package.");
        }
        if (hotel == null || hotel.isBlank()) {
            throw new IllegalStateException("Hotel must be set before building a travel package.");
        }
        if (transport == null || transport.isBlank()) {
            throw new IllegalStateException("Transport must be set before building a travel package.");
        }
        if (days < MIN_DAYS || days > MAX_DAYS) {
            throw new IllegalStateException(
                    "Trip length must be between " + MIN_DAYS + " and " + MAX_DAYS +
                            " days, but was " + days + ".");
        }
    }
}
