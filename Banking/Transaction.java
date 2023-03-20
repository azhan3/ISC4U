package Banking;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

class Transaction {
    String type;
    String amount;
    String oldBalance;
    String currentBalance;
    String difference;

    public Transaction(double amt, String kind, double old, double cur) {
        this.amount = String.format("%.2f", amt);
        this.type = kind;
        this.oldBalance = String.format("%.2f", old);
        this.currentBalance = String.format("%.2f", cur);
        this.difference = kind.equals("Withdraw") ? "-$" : "+$";
    }

    public String report(int longest1, int longest2, int longest3, int minimum) {
        String spaces1 = " ".repeat(longest1 - this.amount.length() + 6);
        String spaces2 = " ".repeat(longest2 - this.oldBalance.length() + 3);
        String spaces3 = " ".repeat(longest3 - this.currentBalance.length());

        //System.out.println(longest3);
        String report = String.format("|   %s   %s|   %s%s%s$%s%s →   $%s%s   %s", this.type, (this.difference.equals("-$") ? "" : " "), this.difference, this.amount, spaces1, this.oldBalance, spaces2, this.currentBalance, spaces3, "|");
        return report;
    }
}