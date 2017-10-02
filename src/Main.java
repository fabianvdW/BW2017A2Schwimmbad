import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯//
        //Var AnzPersonen
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

        //Var Gutscheine und Kalendarische bedingungen
        int anzahlGutscheine = intAbfrage("Wie viele Gutscheine besitzen sie?");
        boolean isVacation = booleanAbfrage("Sind Ferien? Ja oder Nein");
        boolean isWeekend = booleanAbfrage("Ist Wochenende? Ja oder Nein");
        //_____________________________________________________________________________________________//

        //Calculation

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

