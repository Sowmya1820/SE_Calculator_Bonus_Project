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
    boolean isResultDisplayed = false; // Flag to track if the result is displayed

    CalculatorUI() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setEditable(false);
        textField.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(textField);

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

        functionButtons = new JButton[] {
            addButton, subButton, mulButton, divButton, modButton,
            decButton, equButton, clrButton, delButton, negButton, sqrtButton, logButton
        };

        for (JButton button : functionButtons) {
            button.addActionListener(this);
            button.setFont(new Font("Arial", Font.BOLD, 18));
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(new Font("Arial", Font.BOLD, 18));
        }

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 400);
        panel.setLayout(new GridLayout(5, 4, 10, 10));

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
        

        frame.add(panel);
        frame.setVisible(true);
    }

    private double parseInput(String input) {
        if (input.isEmpty()) {
            return 0; // Default to 0 if the input is empty
        }
        return Double.parseDouble(input);
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                if (isResultDisplayed) {
                    textField.setText(""); // Clear screen if a result was displayed
                    isResultDisplayed = false;
                }
                if (textField.getText().length() < 8) { // Limit to 8 digits
                    textField.setText(textField.getText() + i);
                }
            }
        }

        if (e.getSource() == decButton) {
            if (isResultDisplayed) {
                textField.setText(""); // Clear screen if a result was displayed
                isResultDisplayed = false;
            }
            if (!textField.getText().contains(".")) {
                textField.setText(textField.getText() + ".");
            }
        }

        if (e.getSource() == addButton) {
            num1 = parseInput(textField.getText());
            operator = '+';
            textField.setText("");
            isResultDisplayed = false;
        }

        if (e.getSource() == subButton) {
            num1 = parseInput(textField.getText());
            operator = '-';
            textField.setText("");
            isResultDisplayed = false;
        }

        if (e.getSource() == mulButton) {
            num1 = parseInput(textField.getText());
            operator = '*';
            textField.setText("");
            isResultDisplayed = false;
        }

        if (e.getSource() == divButton) {
            num1 = parseInput(textField.getText());
            operator = '/';
            textField.setText("");
            isResultDisplayed = false;
        }

        if (e.getSource() == modButton) {
            num1 = parseInput(textField.getText());
            operator = '%';
            textField.setText("");
            isResultDisplayed = false;
        }

        if (e.getSource() == equButton) {
            num2 = parseInput(textField.getText());
            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/': 
                    if (num2 != 0) result = num1 / num2;
                    else {
                        textField.setText("ERR");
                        return;
                    }
                    break;
                case '%': result = num1 % num2; break;
            }
            if (String.valueOf(result).length() > 8) {
                textField.setText("ERR");
            } else {
                textField.setText(String.valueOf(result));
                isResultDisplayed = true; // Mark that a result is displayed
            }
        }

        if (e.getSource() == clrButton) {
            textField.setText("");
            isResultDisplayed = false;
        }

        if (e.getSource() == delButton) {
            textField.setText("0");
            num1 = num2 = result = 0;
            isResultDisplayed = false;
        }

        if (e.getSource() == negButton) {
            double temp = parseInput(textField.getText());
            textField.setText(String.valueOf(temp * -1));
            isResultDisplayed = false;
        }

        if (e.getSource() == sqrtButton) {
            double temp = parseInput(textField.getText());
            if (temp < 0) {
                textField.setText("ERR");
            } else {
                textField.setText(String.valueOf(Math.sqrt(temp)));
                isResultDisplayed = true;
            }
        }

        if (e.getSource() == logButton) {
            double temp = parseInput(textField.getText());
            if (temp <= 0) {
                textField.setText("ERR");
            } else {
                textField.setText(String.valueOf(Math.log10(temp)));
                isResultDisplayed = true;
            }
        }
    }

    public static void main(String[] args) {
        new CalculatorUI();
    }
}