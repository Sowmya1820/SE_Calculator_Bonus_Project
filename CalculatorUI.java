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

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handling number buttons
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                if (isResultDisplayed) {
                    textField.setText(""); // Clear the text field if a result was displayed
                    isResultDisplayed = false;
                }
                if (textField.getText().length() < 8) { // Limit to 8 digits
                    textField.setText(textField.getText() + i);
                }
            }
        }

        // Handling the decimal button
        if (e.getSource() == decButton) {
            if (isResultDisplayed) {
                textField.setText(""); // Clear the text field if a result was displayed
                isResultDisplayed = false;
            }
            if (!textField.getText().contains(".")) {
                if (textField.getText().isEmpty()) {
                    textField.setText("0."); // Start with 0 if the field is empty
                } else {
                    textField.setText(textField.getText() + ".");
                }
            }
        }

        // Handling operator buttons
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
            isResultDisplayed = false;
        }

        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
            isResultDisplayed = false;
        }

        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
            isResultDisplayed = false;
        }

        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
            isResultDisplayed = false;
        }

        if (e.getSource() == modButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '%';
            textField.setText("");
            isResultDisplayed = false;
        }

        // Handling the equals button
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/': 
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        textField.setText("ERR");
                        return;
                    }
                    break;
                case '%': result = num1 % num2; break;
            }
            // Display result
            if (String.valueOf(result).length() > 8) {
                textField.setText("ERR");
            } else {
                textField.setText(String.valueOf(result));
                isResultDisplayed = true;
            }
        }

        // Handling negation button
        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(textField.getText());
            temp *= -1; // Toggle the sign
            textField.setText(String.valueOf(temp));
        }

        // Handling square root button
        if (e.getSource() == sqrtButton) {
            double temp = Double.parseDouble(textField.getText());
            if (temp < 0) {
                textField.setText("ERR"); // Error for negative input
            } else {
                textField.setText(String.valueOf(Math.sqrt(temp))); // Compute square root
                isResultDisplayed = true;
            }
        }

        // Handling logarithm button
        if (e.getSource() == logButton) {
            double temp = Double.parseDouble(textField.getText());
            if (temp <= 0) {
                textField.setText("ERR"); // Error for non-positive input
            } else {
                textField.setText(String.valueOf(Math.log10(temp))); // Compute base-10 logarithm
                isResultDisplayed = true;
            }
        }

        // Handling Clear button (C)
        if (e.getSource() == clrButton) {
            textField.setText(""); // Clear the current input
        }

        // Handling All Clear button (AC)
        if (e.getSource() == delButton) {
            textField.setText("0"); // Reset the screen to 0
            num1 = 0;
            num2 = 0;
            result = 0;
            operator = '\0'; // Reset the operator
            isResultDisplayed = false; // Reset the result flag
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        new CalculatorUI(); // Create an instance of the updated calculator
    }
}