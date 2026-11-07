package eventticket;

public final class StandardTicket implements Ticket {
    private final String holderName;
    private final String seat;
    private final double basePrice;

    public StandardTicket(String holderName, String seat, double basePrice) {
        this.holderName = holderName;
        this.seat = seat;
        this.basePrice = basePrice;
    }

    public String getHolderName() { return holderName; }
    public String getSeat() { return seat; }
    public double getBasePrice() { return basePrice; }

    @Override
    public void accept(TicketVisitor visitor) {
        visitor.visitStandardTicket(this); // double dispatch
    }
}
