public class VipPackagePricingStrategy implements PricingStrategy {
    private final double vipServiceFee;

    public VipPackagePricingStrategy(double vipServiceFee) {
        this.vipServiceFee = vipServiceFee;
    }

    @Override
    public double calculatePrice(double basePrice) {
        // VIP билет включает базовую стоимость + надбавку за сервис (lounge zone, drinks)
        return basePrice * 1.5 + vipServiceFee;
    }
}