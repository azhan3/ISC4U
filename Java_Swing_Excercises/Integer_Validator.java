package Java_Swing_Excercises;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Integer_Validator extends JFrame implements ActionListener {
    private JLabel messageLabel;
    private JTextField inputField;
    
    public Integer_Validator() {
        setTitle("Integer Input Verifier");
        setSize(400, 200);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.PAGE_AXIS)); 
        JLabel inputLabel = new JLabel("Enter an integer:");
        inputField = new JTextField(20);
        inputField.setFont(new Font("SansSerif", Font.PLAIN, 16));
        inputPanel.add(inputLabel);
        inputPanel.add(inputField);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        JButton verifyButton = new JButton("Verify");
        verifyButton.addActionListener(this);
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        buttonPanel.add(verifyButton);
        buttonPanel.add(cancelButton);
        
        messageLabel = new JLabel("");
        messageLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(messageLabel, BorderLayout.SOUTH);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        try {
            int input = Integer.parseInt(inputField.getText());
            messageLabel.setText(input + " is an integer.");
        } catch (NumberFormatException ex) {
            messageLabel.setText(inputField.getText() + " is not an integer.");
        }
    }
    
    public static void main(String[] args) {
        new Integer_Validator();
    }
}