import java.util.List;

public class TicketList {

    private List<Ticket> tickets;

    public TicketList(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    @Override
    public String toString() {
        return "TicketList{" +
                "tickets=" + tickets +
                '}';
    }
}
