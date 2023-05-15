package UML;

public class Checking extends Account {
    private float spendingLimit;

    public Checking(int accountNumber, float balance, float spendingLimit) {
        super(accountNumber, balance);
        this.spendingLimit = spendingLimit;
    }

    @Override
    public void deposit(float amount) {
        balance += amount;
        Transaction transaction = new Transaction(accountNumber, "Deposit", amount, balance);
        transactionHistory.add(transaction);
    }

    @Override
    public void withdraw(float amount) {
        if (balance >= amount) {
            balance -= amount;
            Transaction transaction = new Transaction(accountNumber, "Withdrawal", amount, balance);
            transactionHistory.add(transaction);
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public void sendMoney(Account destinationAccount, float amount) {
        if (balance >= amount && amount <= spendingLimit) {
            balance -= amount;
            destinationAccount.deposit(amount);
            Transaction transaction = new Transaction(accountNumber, "Money Sent", amount, balance);
            transactionHistory.add(transaction);
        } else {
            System.out.println("Insufficient funds or spending limit exceeded");
        }
    }

    public void receiveMoney(Account sourceAccount, float amount) {
        if (amount <= spendingLimit) {
            balance += amount;
            sourceAccount.withdraw(amount);
            Transaction transaction = new Transaction(accountNumber, "Money Received", amount, balance);
            transactionHistory.add(transaction);
        } else {
            System.out.println("Spending limit exceeded");
        }
    }
}