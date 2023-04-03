package Java_Swing_Excercises;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {
    private JTextField num1Field, num2Field, resultField;
    
    public Calculator() {
        setTitle("Simple Calculator");
        setSize(400, 200);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));
        JLabel num1Label = new JLabel("Number 1:");
        num1Field = new JTextField();
        JLabel num2Label = new JLabel("Number 2:");
        num2Field = new JTextField();
        inputPanel.add(num1Label);
        inputPanel.add(num1Field);
        inputPanel.add(num2Label);
        inputPanel.add(num2Field);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4));
        JButton addButton = new JButton("+");
        addButton.addActionListener(this);
        JButton subtractButton = new JButton("-");
        subtractButton.addActionListener(this);
        JButton multiplyButton = new JButton("*");
        multiplyButton.addActionListener(this);
        JButton divideButton = new JButton("/");
        divideButton.addActionListener(this);
        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);
        
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new FlowLayout());
        JLabel resultLabel = new JLabel("Result:");
        resultField = new JTextField(20);
        resultField.setEditable(false);
        resultPanel.add(resultLabel);
        resultPanel.add(resultField);
        
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(resultPanel, BorderLayout.SOUTH);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = 0.0;
            
            if (e.getActionCommand().equals("+")) {
                result = num1 + num2;
            } else if (e.getActionCommand().equals("-")) {
                result = num1 - num2;
            } else if (e.getActionCommand().equals("*")) {
                result = num1 * num2;
            } else if (e.getActionCommand().equals("/")) {
                if (num2 == 0) {
                    throw new ArithmeticException("Division by zero not allowed");
                }
                result = num1 / num2;
            }
            
            resultField.setText(String.format("%.2f", result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String[] args) {
        new Calculator();
    }
}
