package eventticket;

public final class VipTicket implements Ticket {
    private final String holderName;
    private final String seat;
    private final double basePrice;
    private final boolean backstageAccess;

    public VipTicket(String holderName, String seat, double basePrice, boolean backstageAccess) {
        this.holderName = holderName;
        this.seat = seat;
        this.basePrice = basePrice;
        this.backstageAccess = backstageAccess;
    }

    public String getHolderName() { return holderName; }
    public String getSeat() { return seat; }
    public double getBasePrice() { return basePrice; }
    public boolean hasBackstageAccess() { return backstageAccess; }

    @Override
    public void accept(TicketVisitor visitor) {
        visitor.visitVipTicket(this); // double dispatch
    }
}
