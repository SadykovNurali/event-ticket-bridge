package eventticket;

public class Main {
    public static void main(String[] args) {
        TicketOrder order = new TicketOrder();
        order.add(new StandardTicket("Aigerim", "A-12", 100));
        order.add(new VipTicket("Daniyar", "VIP-1", 200, true));
        order.add(new StudentTicket("Nurali", "C-45", 100, "SE-2509"));

        TicketPrinterVisitor printer = new TicketPrinterVisitor();
        order.accept(printer);
        System.out.println("=== Tickets ===");
        System.out.print(printer.getOutput());

        PriceCalculatorVisitor calculator = new PriceCalculatorVisitor();
        order.accept(calculator);
        System.out.printf("%n=== Total price: %.2f ===%n", calculator.getTotal());

        AccessControlVisitor access = new AccessControlVisitor();
        order.accept(access);
        System.out.println("\n=== Gate access ===");
        access.getReport().forEach(System.out::println);

        LoyaltyPointsVisitor loyalty = new LoyaltyPointsVisitor();
        order.accept(loyalty);
        System.out.println("\n=== Loyalty points: " + loyalty.getPoints() + " ===");
    }
}
