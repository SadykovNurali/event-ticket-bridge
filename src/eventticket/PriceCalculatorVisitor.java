package eventticket;

public final class PriceCalculatorVisitor implements TicketVisitor {
    private static final double VIP_SURCHARGE = 0.50;
    private static final double BACKSTAGE_FEE = 20.0;
    private static final double STUDENT_DISCOUNT = 0.30;

    private double total;

    @Override
    public void visitStandardTicket(StandardTicket ticket) {
        total += ticket.getBasePrice();
    }

    @Override
    public void visitVipTicket(VipTicket ticket) {
        double price = ticket.getBasePrice() * (1 + VIP_SURCHARGE);
        if (ticket.hasBackstageAccess()) {
            price += BACKSTAGE_FEE;
        }
        total += price;
    }

    @Override
    public void visitStudentTicket(StudentTicket ticket) {
        total += ticket.getBasePrice() * (1 - STUDENT_DISCOUNT);
    }

    public double getTotal() { return total; }
}
