public class Main {
    public static void main(String[] args) {

        EventBookingFacade bookingFacade = new EventBookingFacade();

        System.out.println("CLIENT 1: Purchasing VIP Ticket via Facade ");
        bookingFacade.bookEventTicket("CONCERT-2026", "A-1", "VIP", "@example.com", "Credit Card");

        System.out.println(" CLIENT 2: Purchasing Standard Ticket via Facade ");
        bookingFacade.bookEventTicket("CONCERT-2026", "B-15", "STANDARD", "@example.com", "Debit Card");

        System.out.println("CLIENT 3: System Administrator direct access (Bypassing Facade) ");
        SeatInventoryManager adminInventory = new SeatInventoryManager();
        adminInventory.reserveSeat("CONCERT-2026", "ADMIN-RESERVED-01");
    }
}