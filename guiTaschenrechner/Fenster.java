import javax.swing.JFrame;
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
    calculation = new JTextField(15);
    answer = new JTextField(15);
    answer.setEditable(false);

    add(buttonEvaluate);
    add(calculation);
    add(answer);


    }

}
