import java.util.ArrayList;

public class Preisliste {
    boolean isWeekend;
    boolean isVacation;
    int anzahlGutscheine;
    public ArrayList<Ticket> availableTickets;

    public Preisliste(boolean isWeekend, boolean isVacation, int anzahlGutscheine) {
        this.isWeekend = isWeekend;
        this.isVacation = isVacation;
        if (isVacation) {
            this.anzahlGutscheine = 0;
        } else {
            this.anzahlGutscheine = anzahlGutscheine;
        }
        availableTickets = new ArrayList<Ticket>();
        if (isWeekend) {
            //Nach Ersparnis gegenüber Einzelpreisen geordnet siehe ODs Tabelle
            availableTickets.add(new Ticket(2, 2, "Familienticket", 8));//-50%
            availableTickets.add(new Ticket(1, 3, "Familienticket", 8));//-37.5%

            availableTickets.add(new Ticket(1, 0, "Einzel Erwachsene", 3.5));//-0%
            availableTickets.add(new Ticket(0, 1, "Einzel Jugendliche", 2.5));//-0%
        } else {
            //Nach Ersparnis gegenüber Einzelpreisen geordnet siehe ODS Tabelle
            availableTickets.add(new Ticket(6, 0, "Tageskarte", 11));//-52,7%
            availableTickets.add(new Ticket(5, 1, "Tageskarte", 11));//-45,5%
            availableTickets.add(new Ticket(4, 2, "Tageskarte", 11));//-38,2%
            availableTickets.add(new Ticket(3, 3, "Tageskarte", 11));//-31%
            availableTickets.add(new Ticket(5, 0, "Tageskarte", 11));//-27,27%
            availableTickets.add(new Ticket(2, 4, "Tageskarte", 11));//-23,64%
            availableTickets.add(new Ticket(4, 1, "Tageskarte", 11));//-20%
            availableTickets.add(new Ticket(2, 2, "Familienticket", 8));//-20%
            availableTickets.add(new Ticket(1, 5, "Tageskarte", 11));//-16,4%
            availableTickets.add(new Ticket(3, 2, "Tageskarte", 11));//-12,73%
            availableTickets.add(new Ticket(1, 3, "Familienticket", 8));//-10%
            availableTickets.add(new Ticket(0, 6, "Tageskarte", 11));//-9,1%
            availableTickets.add(new Ticket(2, 3, "Tageskarte", 11));//-5,45%
            availableTickets.add(new Ticket(4, 0, "Tageskarte", 11));//-1,82%
            availableTickets.add(new Ticket(1, 0, "Einzel Erwachsene", 2.8));//-0%
            availableTickets.add(new Ticket(0, 1, "Einzel Jugendliche", 2));//-0%
        }
    }
}
