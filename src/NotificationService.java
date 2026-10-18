
public class NotificationService {

    public void sendTicketConfirmation(String userEmail, String ticketData, String seatNumber) {
        System.out.println("[Notification] Sending confirmation email to " + userEmail + " with details: " + ticketData);
    }
}