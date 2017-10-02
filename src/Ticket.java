public class Ticket {
    private double preis;
    int anzE;
    int anzK;
    String name;
    boolean GutscheinUse=false;
    boolean ZehnProzentUse=false;
    public Ticket(Ticket t){
        this.preis=t.preis;
        this.anzE=t.anzE;
        this.anzK=t.anzK;
        this.name=t.name;
    }
    public Ticket(int anzE, int anzK, String name, double preis){
       this.anzE=anzE;
       this.anzK=anzK;
       this.name=name;
       this.preis=preis;
    }
    public double getPreis(){
        if(GutscheinUse){
            return  0;
        }else if(ZehnProzentUse){
            return 0.9*preis;
        }else{
            return preis;
        }
    }

    @Override
    public String toString(){
        String s = "";
        s+=name+=": "+this.getPreis()+" Euro für: "+anzE+" Erwachsene und "+anzK+" Jugendliche";
        if(GutscheinUse){
            s+=" (Gutschein hierfür benutzen)";
        }else if(ZehnProzentUse){
            s+=" (Zehn Prozent auf alle Karten, die das hier stehen haben)";
        }
        return s;
    }
}
