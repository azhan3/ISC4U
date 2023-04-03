package Java_Swing_Excercises;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.*;

public class CurrencyConverter extends JFrame implements ActionListener {
    private JComboBox<String> fromCurrencyBox, toCurrencyBox;
    private JTextField amountField, resultField;
    private JButton convertButton;

    private String[] currencies = {"CAD - Canadian Dollar", "USD - US Dollar", "EUR - Euro", "JPY - Japanese Yen", "CNY - Chinese Yuan", "MXN - Mexican Peso"};
    private double[] exchangeRates = {1.0, 0.74, 0.68, 98.67, 5.08, 13.36};

    public CurrencyConverter() throws IOException {
        setTitle("Currency Converter");
        setSize(400, 250);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        Image img = ImageIO.read(new File("Java_Swing_Excercises/currency.png")).getScaledInstance(65, 50, Image.SCALE_DEFAULT);;
        JLabel pic = new JLabel(new ImageIcon(img));
        JPanel inputPanel = new JPanel();
        
        inputPanel.setBackground(Color.BLACK);
        inputPanel.setLayout(new GridLayout(3, 2, 5, 5));
        JLabel fromLabel = new JLabel("From Currency:");
        fromLabel.setForeground(Color.WHITE);
        JLabel toLabel = new JLabel("To Currency:");
        toLabel.setForeground(Color.WHITE);
        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setForeground(Color.WHITE);
        fromCurrencyBox = new JComboBox<>(currencies);
        fromCurrencyBox.setPreferredSize(new Dimension(150, 20));
        toCurrencyBox = new JComboBox<>(currencies);
        toCurrencyBox.setPreferredSize(new Dimension(150, 20));
        amountField = new JTextField(10);
        inputPanel.add(fromLabel);
        inputPanel.add(fromCurrencyBox);
        inputPanel.add(toLabel);
        inputPanel.add(toCurrencyBox);
        inputPanel.add(amountLabel);
        inputPanel.add(amountField);
        JPanel buttonPanel = new JPanel();
        convertButton = new JButton("Convert");
        convertButton.addActionListener(this);
        buttonPanel.add(convertButton);
        buttonPanel.add(pic, BorderLayout.WEST);
        buttonPanel.setBackground(Color.BLACK);

        JPanel outputPanel = new JPanel();
        outputPanel.setLayout(new GridLayout(2, 1));
        outputPanel.setBackground(Color.BLACK);
        JLabel resultLabel = new JLabel("Result:");
        resultField = new JTextField(10);
        resultField.setEditable(false);
        resultField.setBackground(Color.BLACK);
        resultField.setForeground(Color.WHITE);
        resultLabel.setForeground(Color.WHITE);
        outputPanel.add(resultLabel);
        outputPanel.add(resultField);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(outputPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            String fromCurrency = currencies[fromCurrencyBox.getSelectedIndex()];
            String toCurrency = currencies[toCurrencyBox.getSelectedIndex()];
            double amount = Double.parseDouble(amountField.getText());

            int fromIndex = getIndex(fromCurrency);
            int toIndex = getIndex(toCurrency);

            double rate = exchangeRates[toIndex] / exchangeRates[fromIndex];
            double convertedAmount = amount * rate;

            resultField.setText(String.format("%.2f %s = %.2f %s", amount, fromCurrency.substring(5), convertedAmount, toCurrency.substring(5)));
        } catch (NumberFormatException ex) {
            resultField.setText("Invalid input");
        }
    }

    private int getIndex(String currency) {
        for (int i = 0; i < currencies.length; i++) {
            if (currencies[i].equals(currency)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        new CurrencyConverter();
    }
}