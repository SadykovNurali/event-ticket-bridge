public class EmailRenderer implements TicketRenderer {
    @Override
    public void render(String event, String seat, double price) {
        System.out.println("To: customer@mail.com");
        System.out.println("Subject: Your ticket for " + event);
        System.out.println("Seat " + seat + ", price " + price + " KZT. See you there!");
    }
}
