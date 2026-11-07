# Event Ticket — Visitor Pattern (Java)

Build & run:
    javac -d out src/eventticket/*.java
    java -cp out eventticket.Main

| Role              | Classes |
|-------------------|---------|
| Element           | `Ticket` |
| Concrete Elements | `StandardTicket`, `VipTicket`, `StudentTicket` |
| Visitor           | `TicketVisitor` |
| Concrete Visitors | `PriceCalculatorVisitor`, `TicketPrinterVisitor`, `AccessControlVisitor`, `LoyaltyPointsVisitor` |
| Object Structure  | `TicketOrder` |

## Clean Code principles
1. **Meaningful names** — Elements are nouns (`VipTicket`), Visitors are named by operation (`PriceCalculatorVisitor`); `visitVipTicket` states exactly which type it handles.
2. **No instanceof / type checks** — double dispatch: `ticket.accept(v)` -> `v.visitVipTicket(this)`.
3. **Single Responsibility** — each visitor implements one operation (price, print, access, points) across all tickets.
4. **Open/Closed** — `LoyaltyPointsVisitor` was added without touching any ticket or other visitor.
5. **Minimal encapsulation trade-off** — visitors need ticket data, so tickets expose read-only getters only; classes are `final`, fields `private final`, no setters (immutable).
6. **No magic numbers** — prices/discounts are named constants (`VIP_SURCHARGE`, `STUDENT_DISCOUNT`).
7. **Defensive structure** — `TicketOrder.getTickets()` returns an unmodifiable list.

Trade-off: adding a new Ticket type requires a new `visitX()` in every visitor — Visitor suits a stable element hierarchy with growing operations.
