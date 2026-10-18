
public class SeatInventoryManager {

    public boolean reserveSeat(String eventId, String seatNumber) {
        System.out.println("[Inventory] Locking seat " + seatNumber + " for event " + eventId);
        return true;
    }

    public void releaseSeat(String eventId, String seatNumber) {
        System.out.println("[Inventory] Reservation canceled! Releasing lock on seat " + seatNumber + ".");
    }
}