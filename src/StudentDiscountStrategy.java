public class StudentDiscountStrategy implements PricingStrategy {
    private final double discountPercentage;

    public StudentDiscountStrategy(double discountPercentage) {
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Discount percentage must be between 0 and 100.");
        }
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double calculatePrice(double basePrice) {
        return basePrice * (1.0 - discountPercentage / 100.0);
    }
}