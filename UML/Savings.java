package UML;

public class Savings extends Account {
    private float interestRate;
    private int period;
    private int withdrawalLimit;

    public Savings(int accountNumber, float balance, float interestRate, int period, int withdrawalLimit) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
        this.period = period;
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    public void deposit(float amount) {
        balance += amount;
        Transaction transaction = new Transaction(accountNumber, "Deposit", amount, balance);
        transactionHistory.add(transaction);
    }

    @Override
    public void withdraw(float amount) {
        if (balance >= amount && withdrawalLimit > 0) {
            balance -= amount;
            withdrawalLimit--;
            Transaction transaction = new Transaction(accountNumber, "Withdrawal", amount, balance);
            transactionHistory.add(transaction);
        } else {
            System.out.println("Insufficient funds or withdrawal limit exceeded");
        }
    }

    public void applyInterest() {
        float interestAmount = balance * interestRate * period;
        balance += interestAmount;
        Transaction transaction = new Transaction(accountNumber, "Interest Applied", interestAmount, balance);
        transactionHistory.add(transaction);
    }
}
