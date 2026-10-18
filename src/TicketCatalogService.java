
public class TicketCatalogService {

    public boolean isEventAvailable(String eventId) {
        System.out.println("[Catalog] Checking availability for event ID: " + eventId);
        return true;
    }

    public double getTicketPrice(String eventId, String seatTier) {
        System.out.println("[Catalog] Calculating price for event: " + eventId + ", tier: " + seatTier);
        if ("VIP".equalsIgnoreCase(seatTier)) {
            return 150.00;
        }
        return 50.00;
    }
}