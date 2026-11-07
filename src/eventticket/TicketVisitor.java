package eventticket;

public interface TicketVisitor {
    void visitStandardTicket(StandardTicket ticket);
    void visitVipTicket(VipTicket ticket);
    void visitStudentTicket(StudentTicket ticket);
}
