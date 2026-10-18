
public class PaymentGatewayService {

    public boolean processPayment(String userEmail, double amount, String paymentMethod) {
        System.out.println("[Payment] Charging $" + amount + " to " + userEmail + " via " + paymentMethod);
        return true;
    }
}