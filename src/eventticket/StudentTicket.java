package eventticket;

public final class StudentTicket implements Ticket {
    private final String holderName;
    private final String seat;
    private final double basePrice;
    private final String studentId;

    public StudentTicket(String holderName, String seat, double basePrice, String studentId) {
        this.holderName = holderName;
        this.seat = seat;
        this.basePrice = basePrice;
        this.studentId = studentId;
    }

    public String getHolderName() { return holderName; }
    public String getSeat() { return seat; }
    public double getBasePrice() { return basePrice; }
    public String getStudentId() { return studentId; }

    @Override
    public void accept(TicketVisitor visitor) {
        visitor.visitStudentTicket(this); // double dispatch
    }
}
