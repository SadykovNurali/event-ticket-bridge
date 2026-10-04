public class Main {
    public static void main(String[] args) {
        Ticket ticket = new StandardTicket("Digital Bridge", "A-12", 20000, new EmailRenderer());
        ticket.issue();

        System.out.println("\n--- switch renderer ---\n");
        ticket.setRenderer(new MobileAppRenderer());
        ticket.issue();

        System.out.println();
        Ticket vip = new VipTicket("Digital Bridge", "VIP-1", 20000, new MobileAppRenderer());
        vip.issue();
        vip.setRenderer(new EmailRenderer());
        vip.issue();
    }
}
