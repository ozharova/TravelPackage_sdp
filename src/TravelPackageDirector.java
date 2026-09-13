/**
 * Director: knows a fixed set of reusable travel package "recipes"
 * so the client doesn't have to repeat the same builder calls
 * every time it needs a common configuration.
 */
public class TravelPackageDirector {

    public TravelPackage createBudgetTrip(String destination) {
        return new TravelPackageBuilder()
                .destination(destination)
                .hotel("2-star hotel")
                .days(3)
                .transport("Bus")
                .build();
    }

    public TravelPackage createLuxuryTrip(String destination) {
        return new TravelPackageBuilder()
                .destination(destination)
                .hotel("5-star resort")
                .days(7)
                .transport("Business class flight")
                .withMeals()
                .withInsurance()
                .withGuide()
                .build();
    }
}
