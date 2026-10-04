public class VipTicket extends Ticket {
    private String event;
    private String seat;
    private double price;

    public VipTicket(String event, String seat, double price, TicketRenderer renderer) {
        super(renderer);
        this.event = event;
        this.seat = seat;
        this.price = price;
    }

    @Override
    public void issue() {
        renderer.render(event + " (VIP)", seat, price * 1.5);
    }
}
