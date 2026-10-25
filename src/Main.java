public class Main {
    public static void main(String[] args) {
        double basePrice = 100.0;
        TicketBooking booking = new TicketBooking("Tech Conference 2026", basePrice, new StandardPricingStrategy());

        System.out.println("Event: " + booking.getEventName());
        System.out.println("Base Price: $" + booking.getBasePrice());
        System.out.println("----------------------------------------");

        System.out.printf("Standard Price: $%.2f%n", booking.calculateFinalPrice());

        booking.setPricingStrategy(new StudentDiscountStrategy(20.0));
        System.out.printf("Student Price (20%% off): $%.2f%n", booking.calculateFinalPrice());

        booking.setPricingStrategy(new EarlyBirdPricingStrategy(40));
        System.out.printf("Early Bird Price (40 days prior): $%.2f%n", booking.calculateFinalPrice());

        booking.setPricingStrategy(new VipPackagePricingStrategy(50.0));
        System.out.printf("VIP Package Price: $%.2f%n", booking.calculateFinalPrice());
    }
}