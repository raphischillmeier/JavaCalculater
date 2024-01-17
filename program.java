import java.util.Scanner;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class program{

    public static void main(String[] args){

        String calcString = askCalculation();

        Object resultCalc = eval(calcString);
        
        System.out.println(resultCalc);
    }

    //method for asking about the calculation input
    public static String askCalculation(){

        //defines a scanner for user input
        Scanner myScanner = new Scanner(System.in);

        //Asks for the caclulation
        System.out.println("Gib deine Rechnung ein:");
        String calc = myScanner.nextLine();

        //returns calc 
        return calc;

    }

    public static Object eval(String calc) {
        try {
            // Klasse von javax.script, ermöglicht das Auffinden und Erstellen von ScriptEngine-Instanzen
            ScriptEngineManager manager = new ScriptEngineManager();

            // Hier wird eine Instanz der ScriptEngine für JavaScript angefordert
            ScriptEngine engine = manager.getEngineByName("js");

            // Die eval-Methode gibt normalerweise ein Object zurück
            Object result = engine.eval(calc);

            return result;
        } catch (ScriptException e) {
            // Fehler beim Auswerten der Rechnung
            e.printStackTrace();
            return null; // Oder handle den Fehler entsprechend
        }
    }

}
    

