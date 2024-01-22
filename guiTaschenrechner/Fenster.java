import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.util.Scanner;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenster extends JFrame {
    
    //erstellt die entsprechenden objekte die für das fenster gebraucht werden
    private JButton buttonEvaluate;
    private JTextField calculation;
    private JTextField answer;

    //konstruktor
    public Fenster(){


        //JFrame kann angezeigt werden
        setVisible(true);

        //Größe JFrame festlegen
        setSize(400, 400);

        //Titel setzen
        setTitle("Taschenrechner");

        //wenn das fenster geschlossen werden soll handlet dasss diese funktion, nicht auf hide
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Setzt den layout manager auf grid (rows)
        setLayout(new GridBagLayout());

        // erstellt die objekte von den benötigten elementen
        buttonEvaluate = new JButton("Ausrechnen:");
        calculation = new JTextField("Gib hier die Rechnung ein");
        answer = new JTextField();
        //setzt answer auf nicht editierbar
        answer.setEditable(false);

        //erstellt gridBagConstraints für jede komponente
        buttonEvaluate.setBounds(20, 20, 150, 30);
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        gbc1.weightx = 1.0;
        gbc1.weighty = 1.0;
        gbc1.fill = GridBagConstraints.CENTER;


        calculation.setBounds(20, 70, 150, 30);
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        gbc2.weightx = 1.0;
        gbc2.weighty = 1.0;
        gbc2.fill = GridBagConstraints.CENTER;


        answer.setBounds(20, 120, 150, 30);
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 0;
        gbc3.gridy = 2;
        gbc3.weightx = 1.0;
        gbc3.weighty = 1.0;
        gbc3.fill = GridBagConstraints.CENTER;


        //addet die elemente und deren grids zu dem fenster dazu
        add(buttonEvaluate, gbc1);
        add(calculation, gbc2);
        add(answer, gbc3);
        
        //event handling für den Button caclulate
        buttonEvaluate.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                
                //nimmt den text aus dem eingabefeld
               String calcStr = calculation.getText();

               //nimmt die evalCalc funktion und rechnet den string aus
               Object calcResult = evalCalc(calcStr);

               //setzt den text für die gerechnete rechnung
               answer.setText(String.valueOf(calcResult));

            }
        });
    }

    //eine funktion um die rechnung auszurechnen
    public static Object evalCalc(String calc){
        //versucht den code auszuführen
        try{

            //greift auf die libary scriptEngineManager zu welche für das engine objekt gebraucht wird
            ScriptEngineManager manager = new ScriptEngineManager();

            //erstellt mithilfe von der libery welche in manager gespreichert ist eine javascript engine
            ScriptEngine engine = manager.getEngineByName("js");

            //diese wird verwendet um auf die eval funktion zuzugreifen
            Object result = engine.eval(calc);

            return result;

            //wenn das nicht funktioniert wird diese ersatzmethode gestartet
        } catch (ScriptException e) {
            e.printStackTrace();
            return null; 
        }

    }

    public static void main(String[] args) {
        // Hier können Sie Ihre Fenster-Instanz erstellen
        Fenster fenster = new Fenster();
    }
}
