public class Ticket {
    double preis;
    int countOlder16;
    int countYounger16;
    String name;

    public Ticket(Boolean older){
        this.preis = 0;
        if (older) {
            this.countOlder16 = 1;
            this.countYounger16 = 0;
        }
        else {
            this.countOlder16 = 0;
            this.countYounger16 = 1;
        }
        this.name = "Freier Eintritt";
    }

    public Ticket(double preis, int countOlder16, int countYounger16, String name){
        this.preis = preis;
        this.countOlder16 = countOlder16;
        this.countYounger16 = countYounger16;
        this.name = name;
    }

    @Override
    public String toString(){
        String s = "";
        if (preis == 0) {
            if (countOlder16 == 1)
                s = "Freier Eintritt für einen Erwachsenen";
            else s = "Freier Eintritt für einen Jugendlichen";
        }
        else if (preis > 0)
            s+=name+=": "+preis+" Euro für: "+countOlder16+" Erwachsene und "+countYounger16+" Jugendliche";
        return s;
    }
}
