package eventticket;


public final class LoyaltyPointsVisitor implements TicketVisitor {
    private int points;

    @Override
    public void visitStandardTicket(StandardTicket ticket) {
        points += (int) (ticket.getBasePrice() / 10);
    }

    @Override
    public void visitVipTicket(VipTicket ticket) {
        points += (int) (ticket.getBasePrice() / 10) * 3;
    }

    @Override
    public void visitStudentTicket(StudentTicket ticket) {
        points += (int) (ticket.getBasePrice() / 10) / 2;
    }

    public int getPoints() { return points; }
}
