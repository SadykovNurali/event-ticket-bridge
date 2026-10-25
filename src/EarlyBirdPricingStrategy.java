public class EarlyBirdPricingStrategy implements PricingStrategy {
    private final int daysBeforeEvent;

    public EarlyBirdPricingStrategy(int daysBeforeEvent) {
        this.daysBeforeEvent = daysBeforeEvent;
    }

    @Override
    public double calculatePrice(double basePrice) {
        if (daysBeforeEvent >= 30) {
            return basePrice * 0.70; // 30% скидка за 30+ дней
        } else if (daysBeforeEvent >= 14) {
            return basePrice * 0.85; // 15% скидка за 14+ дней
        }
        return basePrice;
    }
}