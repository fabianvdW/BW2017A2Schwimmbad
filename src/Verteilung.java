import java.util.ArrayList;

public class Verteilung {

    ArrayList<Ticket> tickets;
    public Verteilung(ArrayList<Ticket> tickets) {
        this.tickets=tickets;
        for(Ticket t: tickets){
        }
    }
    public void addV(Verteilung v){
        this.tickets.addAll(v.tickets);
    }
    public double getPreis(){
        double preis=0;
        for(Ticket t: tickets){
            preis+=t.getPreis();
        }
        return preis;
    }
    @Override
    public String toString(){
        String s="";
        for(Ticket t: tickets){
            s+=t.toString()+"\n";
        }
        s+="Gesamtpreis: "+this.getPreis();
        return s;
    }
}
