public class TicketBooking {
    private final String eventName;
    private final double basePrice;
    private PricingStrategy pricingStrategy;

    public TicketBooking(String eventName, double basePrice, PricingStrategy pricingStrategy) {
        this.eventName = eventName;
        this.basePrice = basePrice;
        this.pricingStrategy = pricingStrategy;
    }

    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public double calculateFinalPrice() {
        return pricingStrategy.calculatePrice(basePrice);
    }

    public String getEventName() {
        return eventName;
    }

    public double getBasePrice() {
        return basePrice;
    }
}