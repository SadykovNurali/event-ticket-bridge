
import java.util.UUID;

// Interface for different ticket types
interface Ticket {
    String generateContent(String eventId, String seatNumber);
}

// Standard ticket implementation
class StandardTicket implements Ticket {
    @Override
    public String generateContent(String eventId, String seatNumber) {
        return "[Standard Ticket Barcode: " + UUID.randomUUID().toString().substring(0, 8).toUpperCase() + "]";
    }
}

// VIP ticket implementation
class VipTicket implements Ticket {
    @Override
    public String generateContent(String eventId, String seatNumber) {
        return "[VIP Ticket QR-Code + Access to VIP Lounge + Personal Concierge]";
    }
}

// Simple Factory inside subsystem
class TicketFactory {
    public static Ticket createTicket(String seatTier) {
        if ("VIP".equalsIgnoreCase(seatTier)) {
            return new VipTicket();
        }
        return new StandardTicket();
    }
}

public class TicketGeneratorService {

    public String generateETicket(String eventId, String seatNumber, String seatTier) {
        Ticket ticket = TicketFactory.createTicket(seatTier);
        String ticketData = ticket.generateContent(eventId, seatNumber);

        System.out.println("[Generator] Generated " + seatTier + " tier e-ticket: " + ticketData);
        return ticketData;
    }
}