package UML;

import java.util.ArrayList;

public abstract class Account {
    protected int accountNumber;
    protected ArrayList<Transaction> transactionHistory;
    protected float balance;

    public Account(int accountNumber, float balance) {
        this.accountNumber = accountNumber;
        this.transactionHistory = new ArrayList<>();
        this.balance = balance;
    }

    public abstract void deposit(float amount);

    public abstract void withdraw(float amount);

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + String.format("%.2f", balance));
    }

    public ArrayList<Transaction> getTransactions() {
        return transactionHistory;
    }

    public void moveFunds(Account destinationAccount, float amount) {
        if (balance >= amount) {
            balance -= amount;
            destinationAccount.deposit(amount);
            Transaction transaction = new Transaction(accountNumber, "Funds Transfer", amount, balance);
            transactionHistory.add(transaction);
        } else {
            System.out.println("Insufficient funds");
        }
    }
}