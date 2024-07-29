package calculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {

    JTextField text = new JTextField(50);
    JPanel panel = new JPanel();

    double firstOpp = 1;
    double secondOpp = 2;
    char Operator;
    private String current = "";

    Calculator() {
        setSize(380, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("CALCULATOR");
        setLayout(new BorderLayout());

        text.setFont(new Font("Arial", Font.PLAIN, 24));
        text.setPreferredSize(new Dimension(380, 50));

        text.setEditable(false);

        panel.setLayout(new GridLayout(5, 4));

        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");
        JButton b0 = new JButton("0");
        JButton beq = new JButton("=");
        JButton badd = new JButton("+");
        JButton bsub = new JButton("-");
        JButton bdiv = new JButton("/");
        JButton bmulti = new JButton("*");
        JButton bper = new JButton("%");
        JButton bdot = new JButton("!");
        JButton bbar = new JButton("^");
        JButton clear = new JButton("C");
        JButton plusMinus = new JButton("+/-");

        Font buttonFont = new Font("Arial", Font.PLAIN, 24);

        JButton[] buttons = {b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, beq, badd, bsub, bdiv, bmulti, bper, bdot, bbar, clear, plusMinus};
        for (JButton button : buttons) {
            button.setFont(buttonFont);
            button.addActionListener(this);
        }

        panel.add(clear);
        panel.add(bbar);
        panel.add(bper);
        panel.add(bdiv);
        panel.add(b7);
        panel.add(b8);
        panel.add(b9);
        panel.add(bmulti);
        panel.add(b4);
        panel.add(b5);
        panel.add(b6);
        panel.add(bsub);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(badd);
        panel.add(plusMinus);
        panel.add(b0);
        panel.add(bdot);
        panel.add(beq);

        add(text, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String match = e.getActionCommand();

        try {
            if (match.equals("C")) {
                current = "";
                text.setText("");
                firstOpp = 0;
                secondOpp = 0;
                Operator = ' ';
            } else if (match.equals("+")) {
                firstOpp = Double.parseDouble(text.getText());
                Operator = '+';
                current = "";
                text.setText("");
            } else if (match.equals("-")) {
                firstOpp = Double.parseDouble(text.getText());
                Operator = '-';
                current = "";
                text.setText("");
            } else if (match.equals("*")) {
                firstOpp = Double.parseDouble(text.getText());
                Operator = '*';
                current = "";
                text.setText("");
            } else if (match.equals("/")) {
                firstOpp = Double.parseDouble(text.getText());
                Operator = '/';
                current = "";
                text.setText("");
            } else if (match.equals("%")) {
                firstOpp = Double.parseDouble(text.getText());
                Operator = '%';
                current = "";
                text.setText("");

            } else if (match.equals("^")) {
                firstOpp = Double.parseDouble(text.getText());
                Operator = '^';
                current = "";
                text.setText("");
            } else if (match.equals("!")) {
                firstOpp = Double.parseDouble(text.getText());
                Operator = '!';
                current = "";
                text.setText("");
//                firstOpp = factorial((int) firstOpp);
//                current = "" + firstOpp;
//                text.setText(current);
            } else if (match.equals("+/-")) {
                double value = Double.parseDouble(text.getText());
                value = value * -1;
                text.setText(String.valueOf(value));
                current = text.getText();
            } else if (match.equals("=")) {
                if (!current.isEmpty()) {
                    secondOpp = Double.parseDouble(current);
                }
                if (Operator == '+') {
                    firstOpp = firstOpp + secondOpp;
                    current = "" + firstOpp;
                    text.setText(current);
                } else if (Operator == '-') {
                    firstOpp = firstOpp - secondOpp;
                    current = "" + firstOpp;
                    text.setText(current);
                } else if (Operator == '*') {
                    firstOpp = firstOpp * secondOpp;
                    current = "" + firstOpp;
                    text.setText(current);
                } else if (Operator == '/') {
                    if (secondOpp != 0) {
                        firstOpp = firstOpp / secondOpp;
                        current = "" + firstOpp;
                        text.setText(current);
                    } else {
                        text.setText("Error");
                    }
                } else if (Operator == '%') {
                    if ((firstOpp != 0) & (secondOpp == 0)) {
                        firstOpp = firstOpp / 100;
                        current = "" + firstOpp;
                        text.setText(current);
                    } else if ((firstOpp != 0) & (secondOpp != 0)) {
                        firstOpp = firstOpp * (secondOpp / 100);
                        current = "" + firstOpp;
                        text.setText(current);
                    } else {
                        text.setText("Error");
                    }
                } else if (Operator == '^') {
                    double result = Math.pow(firstOpp, secondOpp);
                    current = "" + result;
                    text.setText(current);
                } else if ((Operator == '!') & (firstOpp != 0)) {
                    firstOpp = factorial((int) firstOpp);
                    current = "" + firstOpp;
                    text.setText(current);
                }
            } else {
                current += match;
            }

            text.setText(current);
        } catch (NumberFormatException ex) {
            text.setText("Error");
        }
    }

    private double factorial(int n) {

        if (n == 0 || n == 1) {
            return 1;
        }
        double result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

}
