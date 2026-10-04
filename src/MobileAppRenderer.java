public class MobileAppRenderer implements TicketRenderer {
    @Override
    public void render(String event, String seat, double price) {
        System.out.println("[ PUSH ] Ticket added to your wallet");
        System.out.println("[ CARD ] " + event + " | " + seat + " | " + price + " KZT");
    }
}
