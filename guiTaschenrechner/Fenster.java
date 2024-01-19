import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Fenster extends JFrame {
    
    private JButton buttonEvaluate;
    private JTextField calculation;
    private JTextField answer;

    public Fenster(){

    setLayout(null);

    setVisible(true);

    setSize(400, 400);

    setTitle("Taschenrechner");

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    buttonEvaluate = new JButton("Ausrechnen:");
    calculation = new JTextField("Gib hier die Rechnung ein");
    answer = new JTextField("Hiwe wird das Ergebnis angezeigt");
    answer.setEditable(false);

    buttonEvaluate.setBounds(20, 20, 150, 30);
    calculation.setBounds(20, 70, 150, 30);
    answer.setBounds(20, 120, 150, 30);

    add(buttonEvaluate);
    add(calculation);
    add(answer);


    }

}
