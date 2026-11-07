package eventticket;

public interface Ticket {
    void accept(TicketVisitor visitor);
}
