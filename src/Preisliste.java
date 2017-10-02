public class Preisliste {
    boolean isWeekend;
    boolean isVacation;
    int anzahlGutscheine;
    double singleOlder16 = 3.5;
    double singleYounger16 = 2.5;
    int tagesKarte = 11; //Bis zu 6 Personen, Nur unter der Woche
    int familienKarte = 8; //2 Erwachsene 2 Younger16 || 1 Erwachsener 3 Younger16

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
