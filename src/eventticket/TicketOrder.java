package eventticket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class TicketOrder {
    private final List<Ticket> tickets = new ArrayList<>();

    public void add(Ticket ticket) {
        tickets.add(ticket);
    }

    public List<Ticket> getTickets() {
        return Collections.unmodifiableList(tickets);
    }

    public void accept(TicketVisitor visitor) {
        for (Ticket ticket : tickets) {
            ticket.accept(visitor);
        }
    }
}
