package eventticket;

import java.util.ArrayList;
import java.util.List;

public final class AccessControlVisitor implements TicketVisitor {
    private final List<String> report = new ArrayList<>();

    @Override
    public void visitStandardTicket(StandardTicket ticket) {
        report.add(ticket.getHolderName() + " -> Main hall");
    }

    @Override
    public void visitVipTicket(VipTicket ticket) {
        String zones = "Main hall, VIP lounge" + (ticket.hasBackstageAccess() ? ", Backstage" : "");
        report.add(ticket.getHolderName() + " -> " + zones);
    }

    @Override
    public void visitStudentTicket(StudentTicket ticket) {
        report.add(ticket.getHolderName() + " -> Main hall (check student ID " + ticket.getStudentId() + ")");
    }

    public List<String> getReport() { return report; }
}
