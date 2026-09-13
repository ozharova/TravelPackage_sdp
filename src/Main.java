/**
 * Client: demonstrates both reusable (Director) and
 * custom (direct Builder) construction of TravelPackage.
 */
public class Main {

    public static void main(String[] args) {
        TravelPackageDirector director = new TravelPackageDirector();

        TravelPackage budgetTrip = director.createBudgetTrip("Almaty");
        System.out.println("Budget trip: " + budgetTrip);

        TravelPackage luxuryTrip = director.createLuxuryTrip("Bali");
        System.out.println("Luxury trip: " + luxuryTrip);

        TravelPackage customTrip = new TravelPackageBuilder()
                .destination("Istanbul")
                .hotel("4-star boutique hotel")
                .days(5)
                .transport("Train")
                .withMeals()
                .build();
        System.out.println("Custom trip: " + customTrip);

        try {
            new TravelPackageBuilder()
                    .destination("Paris")
                    .build();
        } catch (IllegalStateException e) {
            System.out.println("Rejected invalid package: " + e.getMessage());
        }
    }
}
