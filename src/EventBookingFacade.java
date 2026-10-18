
public class EventBookingFacade {

    private final TicketCatalogService catalogService;
    private final SeatInventoryManager inventoryManager;
    private final PaymentGatewayService paymentGateway;
    private final TicketGeneratorService ticketGenerator;
    private final NotificationService notificationService;

    public EventBookingFacade() {
        this.catalogService = new TicketCatalogService();
        this.inventoryManager = new SeatInventoryManager();
        this.paymentGateway = new PaymentGatewayService();
        this.ticketGenerator = new TicketGeneratorService();
        this.notificationService = new NotificationService();
    }

    public boolean bookEventTicket(String eventId, String seatNumber, String seatTier,
                                   String userEmail, String paymentMethod) {
        System.out.println("\n STARTING TICKET RESERVATION PROCESS ");

        if (!catalogService.isEventAvailable(eventId)) {
            System.err.println("[Error] Event is unavailable.");
            return false;
        }

        if (!inventoryManager.reserveSeat(eventId, seatNumber)) {
            System.err.println("[Error] Seat " + seatNumber + " is already taken.");
            return false;
        }

        double price = catalogService.getTicketPrice(eventId, seatTier);
        boolean paymentSuccess = paymentGateway.processPayment(userEmail, price, paymentMethod);

        if (!paymentSuccess) {
            System.err.println("[Error] Payment failed. Rolling back seat reservation...");
            inventoryManager.releaseSeat(eventId, seatNumber); // Rollback
            return false;
        }

        String ticketData = ticketGenerator.generateETicket(eventId, seatNumber, seatTier);

        notificationService.sendTicketConfirmation(userEmail, ticketData, seatNumber);

        System.out.println("BOOKING COMPLETED SUCCESSFULLY \n");
        return true;
    }
}