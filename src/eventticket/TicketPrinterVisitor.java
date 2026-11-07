package eventticket;

public final class TicketPrinterVisitor implements TicketVisitor {
    private final StringBuilder output = new StringBuilder();

    @Override
    public void visitStandardTicket(StandardTicket ticket) {
        output.append(String.format("[STANDARD] %s | seat %s%n",
                ticket.getHolderName(), ticket.getSeat()));
    }

    @Override
    public void visitVipTicket(VipTicket ticket) {
        output.append(String.format("[VIP]      %s | seat %s | backstage: %s%n",
                ticket.getHolderName(), ticket.getSeat(),
                ticket.hasBackstageAccess() ? "yes" : "no"));
    }

    @Override
    public void visitStudentTicket(StudentTicket ticket) {
        output.append(String.format("[STUDENT]  %s | seat %s | ID: %s%n",
                ticket.getHolderName(), ticket.getSeat(), ticket.getStudentId()));
    }

    public String getOutput() { return output.toString(); }
}
