package UML;

public class Transaction {
    private static int transactionCounter = 0;
    private int transactionID;
    private String date;
    private float amount;
    private float afterBalance;

    public Transaction(int accountNumber, String date, float amount, float afterBalance) {
        this.transactionID = ++transactionCounter;
        this.date = date;
        this.amount = amount;
        this.afterBalance = afterBalance;
    }

    public void PrintInfo() {
        System.out.println("Transaction ID: " + transactionID);
        System.out.println("Date: " + date);
        System.out.println("Amount: " + String.format("%.2f", amount));
        System.out.println("Balance after transaction: " + String.format("%.2f", afterBalance));
    }
}
