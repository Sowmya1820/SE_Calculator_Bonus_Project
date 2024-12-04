import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CalculatorUI implements ActionListener {
    JFrame frame;
    JTextField textField;
    JPanel panel;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[12];
    JButton addButton, subButton, mulButton, divButton, modButton;
    JButton decButton, equButton, clrButton, delButton, negButton, sqrtButton, logButton;

    double num1 = 0, num2 = 0, result = 0;
    char operator;
    boolean isResultDisplayed = false;

    CalculatorUI() {
        // Frame setup
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 550);
        frame.setLayout(null);

        // Text field setup
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setEditable(false);
        textField.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(textField);

        // Initializing buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        modButton = new JButton("%");
        decButton = new JButton(".");
        equButton = new JButton("=");
        clrButton = new JButton("C");
        delButton = new JButton("AC");
        negButton = new JButton("+/-");
        sqrtButton = new JButton("√");
        logButton = new JButton("log");

        // Adding buttons to a function button array
        functionButtons = new JButton[] {
            addButton, subButton, mulButton, divButton, modButton,
            decButton, equButton, clrButton, delButton, negButton, sqrtButton, logButton
        };

        // Adding functionality to buttons
        for (JButton button : functionButtons) {
            button.addActionListener(this);
            button.setFont(new Font("Arial", Font.BOLD, 18));
        }

        // Creating number buttons
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(new Font("Arial", Font.BOLD, 18));
        }

        // Panel for buttons
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 400);
        panel.setLayout(new GridLayout(5, 4, 10, 10));

        // Adding buttons to the panel (example order)
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(subButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(mulButton);
        panel.add(divButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(modButton);
        panel.add(equButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(clrButton);
        panel.add(delButton);
        panel.add(negButton);
        panel.add(sqrtButton);
        panel.add(logButton);

        // Adding panel to the frame
        frame.add(panel);

        // Making the frame visible
        frame.setVisible(true);
    }

    // Required method for ActionListener
    @Override
    public void actionPerformed(ActionEvent e) {
        // Placeholder for handling button actions
    }

    // Main method to run the program
    public static void main(String[] args) {
        new CalculatorUI(); 
    }
}
