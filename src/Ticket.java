public abstract class Ticket {
    protected TicketRenderer renderer;

    protected Ticket(TicketRenderer renderer) {
        this.renderer = renderer;
    }

    public void setRenderer(TicketRenderer renderer) {
        this.renderer = renderer;
    }

    public abstract void issue();
}
