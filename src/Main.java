import javax.swing.*;
import java.util.ArrayList;

public class Main {

    static double lowestPreis;

    public static void main(String[] args) {
        //¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯//
        /*//Var AnzPersonen
        int personenInGruppe = intAbfrage("Wie viele Personen sind in der Gruppe?");
        //Checking whether user input is valid
        if (personenInGruppe == 0){
            System.out.println("Gruppe besteht aus keiner Person. Kein Eintritt berechenbar");
            System.exit(0);
        }

        //Var Personenalter
        int personenOlder16 = intAbfrage("Wie viele Personen sind über 16?");
        int personenYounger16 = intAbfrage("Wie viele Personen sind jünger 16?");
        int personenYounger4 = intAbfrage("Wie viele Personen sind unter 4?");

        //Checking whether user input is valid
        if (personenInGruppe != (personenOlder16 + personenYounger16 + personenYounger4)){
            System.out.println("Mehr Personen mit bestimmten Alter angegeben als Personen existent sind");
            System.exit(0);
        }
        if (personenYounger4 != 0 && personenOlder16 != 0){
            System.out.println("Kinder unter 4 Jahren müssen in Begleitung eines über 16 Jährigen sein");
            System.exit(0);
        }

        //Var Gutscheine und Kalendarische bedingungen
        int anzahlGutscheine = intAbfrage("Wie viele Gutscheine besitzen sie?");
        boolean isVacation = booleanAbfrage("Sind Ferien? Ja oder Nein");
        boolean isWeekend = booleanAbfrage("Ist Wochenende? Ja oder Nein");
        */
        int anzE=130;
        int anzK=110;
        boolean isWeekend=false;
        boolean isVacation=false;
        int anzahlGutscheine=22;
        Preisliste preisliste = new Preisliste(isWeekend, isVacation, anzahlGutscheine);
        //_____________________________________________________________________________________________//
        //Calculation
        Verteilung v=verteileAufSchwimmbad(preisliste.availableTickets,anzE,anzK);
        //Gutscheine auf Verteilung anwenden
        if(preisliste.anzahlGutscheine>0) {
            ArrayList<Ticket> tickets = new ArrayList<Ticket>(v.tickets);
            A:
            for (int i = 1; i < preisliste.anzahlGutscheine; i++) {
                //Teuerste EinzelTickets löschen
                for (Ticket t : tickets) {
                    if (t.anzE == 1 && t.anzK == 0) {
                        t.GutscheinUse = true;
                        tickets.remove(t);
                        continue A;
                    }
                }
                for (Ticket t : tickets) {
                    if (t.anzE == 0 && t.anzK == 1) {
                        t.GutscheinUse = true;
                        tickets.remove(t);
                        continue A;
                    }
                }
            }
            double teuersteEinzelKarte = 0;
            Ticket teuerstesTicket=null;
            for (Ticket t : tickets) {
                if ((t.anzK == 0 && t.anzE == 1) || (t.anzK == 1 && t.anzE == 0)) {
                    if (t.getPreis() > teuersteEinzelKarte) {
                        teuersteEinzelKarte = t.getPreis();
                        teuerstesTicket=t;
                    }
                }
            }
            double preisAllerTickets=0;
            for(Ticket t: tickets){
                preisAllerTickets+=t.getPreis();
            }
            if(preisAllerTickets*0.1>teuersteEinzelKarte){
                for(Ticket t: tickets){
                    t.ZehnProzentUse=true;
                }
            }else{
                teuerstesTicket.GutscheinUse=true;
            }
        }
        System.out.println(v.toString());

    }
    public static Verteilung verteileAufSchwimmbad(ArrayList<Ticket> ticketliste, int anzErwachsene, int anzJugendliche){
        if(anzErwachsene+anzJugendliche==0){
            return new Verteilung(new ArrayList<Ticket>());
        }else{
            Verteilung vK= new Verteilung(new ArrayList<Ticket>());
            A:for(Ticket t: ticketliste){
                //System.out.println("AnzE: "+anzErwachsene+", anzJ: "+anzJugendliche);
                //System.out.println("Ticket: "+t.toString());
                //System.out.println("Käuflich?: "+istTicketKaufbar(t,anzErwachsene,anzJugendliche));
                if(istTicketKaufbar(t,anzErwachsene,anzJugendliche)){
                    Verteilung potentziellesVK= new Verteilung(new ArrayList<Ticket>());
                    potentziellesVK.tickets.add(new Ticket(t));
                    Verteilung v2= verteileAufSchwimmbad(ticketliste,anzErwachsene-t.anzE,anzJugendliche-t.anzK);
                    potentziellesVK.addV(v2);
                    if(vK.getPreis()==0||potentziellesVK.getPreis()< vK.getPreis()){
                        vK=potentziellesVK;
                    }
                }
            }
            return vK;
        }
    }
    public static boolean istTicketKaufbar(Ticket t, int anzE, int anzJ){
        return anzE>=t.anzE&& anzJ>=t.anzK;
    }
    public static int intAbfrage(String text){
        int var = 0;
        Exception ex;
        do {
            try {
                ex = null;
                var = Integer.parseInt(JOptionPane.showInputDialog(null, text));
            } catch (Exception e) {
                ex = e;
                JOptionPane.showMessageDialog(null, "Diese Frage ist nur mit Zahlen zu beantworten!");
            }
        }while(ex != null);
        return var;
    }

    public static boolean booleanAbfrage(String text){
        String userInput;
        do{
            userInput = JOptionPane.showInputDialog(null, text);
        }while(!userInput.equals("Ja")&&!userInput.equals("Nein")&&!userInput.equals("nein")&&!userInput.equals("ja"));
        if (userInput.equals("ja")||userInput.equals("Ja")){
            return true;
        }
        else
            return false;
    }
}

