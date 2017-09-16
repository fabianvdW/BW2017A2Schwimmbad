public class Preisliste {
    boolean isWeekend;
    boolean isVacation;
    double singleOlder16 = 3.5;
    double singleYounger16 = 2.5;
    int anzahlGutscheine;
    int tagesKarte = 11;
    int familienKarte = 8;

    public  Preisliste(boolean isWeekend, boolean isVacation, int anzahlGutscheine){
        this.isWeekend = isWeekend;
        this.isVacation = isVacation;
        if(!isWeekend){
            this.singleOlder16 *= 0.8;
            this.singleYounger16 *= 0.8;
        }
        else{
            this.tagesKarte = 10000000;
        }
        if(isVacation){
            this.anzahlGutscheine = 0;
        }
        else{
            this.anzahlGutscheine = anzahlGutscheine;
        }
    }
}
