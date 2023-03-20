package Banking;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.text.DecimalFormat;

class Account {
    double balance;
    double limit;
    String name;
    List<Transaction> log;
    Scanner sc = new Scanner(System.in);
    DecimalFormat df = new DecimalFormat("#0.00");
    
    public Account(String name, double balance, double limit) {
        this.name = name;
        this.balance = balance;
        this.limit = limit;
        this.log = new ArrayList<>();
    }

    public Account() {
        String name;
        int balance, limit;
        System.out.print("Name: ");
        name = sc.nextLine();

        balance = getInput("Starting Balance: ", "That is not a valid value! Please try again", 0);
        limit = getInput("Account Overture Limit: ", "That is not a valid value! Please try again", 0);

        this.name = name;
        this.balance = balance;
        this.limit = limit;
        this.log = new ArrayList<>();
    }

    public int getInput(String message, String ErrorMessage, int threshold) {
        int num;
        while (true) {
            try { 
                System.out.print(message); 
                num = Integer.parseInt(sc.nextLine()); 
                if (num <= threshold) throw new NumberFormatException();
                return num;
            } catch (NumberFormatException nfe) { 
                System.err.println(ErrorMessage);
            }
        }
    } 

    public String getBalance() {
        return String.format("$%.2f", this.balance);
    }

    public String getName() {
        return name;
    }

    public List<String> rep() {
        List<String> report = new ArrayList<>();
        
        if (this.log.size() == 0) {
            report.add("No Transaction History");
            report.add("⠀⠀⠀⠀⠀⠀⠀⠀⢀⣞⣆⢀⣠⢶⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n  ⢀⣀⡤⠤⠖⠒⠋⠉⣉⠉⠹⢫⠾⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n⢠⡏⢰⡴⠀⠀⠀⠉⠙⠟⠃⠀⠀⠀⠈⠙⠦⣄⡀⢀⣀⣠⡤⠤⠶⠒⠒⢿⠋⠈⠀⣒⡒⠲⠤⣄⡀⠀⠀⠀⠀⠀⠀\n⢸⠀⢸⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠀⠴⠂⣀⠀⠀⣴⡄⠉⢷⡄⠚⠀⢤⣒⠦⠉⠳⣄⡀⠀⠀⠀\n⠸⡄⠼⠦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣄⡂⠠⣀⠐⠍⠂⠙⣆⠀⠀\n⠀⠙⠦⢄⣀⣀⣀⣀⡀⠀⢷⠀⢦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠰⡇⠠⣀⠱⠘⣧⠀\n⠀⠀⠀⠀⠀⠀⠀⠈⠉⢷⣧⡄⢼⠀⢀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠀⡈⠀⢄⢸⡄\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⣿⡀⠃⠘⠂⠲⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠀⡈⢘⡇\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢫⡑⠣⠰⠀⢁⢀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⣸⠁\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⣯⠂⡀⢨⠀⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡆⣾⡄⠀⠀⠀⠀⣀⠐⠁⡴⠁⠀\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣧⡈⡀⢠⣧⣤⣀⣀⡀⢀⡀⠀⠀⢀⣼⣀⠉⡟⠀⢀⡀⠘⢓⣤⡞⠁⠀⠀\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢺⡁⢁⣸⡏⠀⠀⠀⠀⠁⠀⠉⠉⠁⠹⡟⢢⢱⠀⢸⣷⠶⠻⡇⠀⠀⠀⠀\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢈⡏⠈⡟⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠑⢄⠁⠀⠻⣧⠀⠀⣹⠁⠀⠀⠀\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⡤⠚⠃⣰⣥⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣾⠼⢙⡷⡻⠀⡼⠁⠀⠀⠀⠀\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠟⠿⡿⠕⠊⠉⠀⠀⠀⠀⠀⠀⠀⠀⣠⣴⣶⣾⠉⣹⣷⣟⣚⣁⡼⠁⠀⠀⠀⠀⠀\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠙⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
            return report;
        }

        int longest1 = Math.max(9, this.log.stream().mapToInt(i -> i.amount.length()).max().getAsInt());
        int longest2 = Math.max(9, this.log.stream().mapToInt(i -> i.oldBalance.length()).max().getAsInt());
        int longest3 = Math.max(9, this.log.stream().mapToInt(i -> i.currentBalance.length()).max().getAsInt());
        System.out.println(longest3);
        report.add(String.format("\n%s's Transaction History", name));
        String topRow = String.format("|   Action         Change%sOld Balance%sNew Balance%s|", " ".repeat(longest1 + 1), " ".repeat(longest2-1), " ".repeat(longest3 - 6));
        List<String> tempReport = new ArrayList<>();
        for (Transaction t : this.log) {
            tempReport.add("+ " + "-".repeat(longest1 + 3) + "-" + "-".repeat(topRow.length() - longest1 - 8) + " +");
            tempReport.add(t.report(longest1, longest2, longest3+1, topRow.length()));
        }
        int reportLength = Collections.max(tempReport, Comparator.comparing(String::length)).length();

        report.add("+ " + "-".repeat(reportLength-4) + " +");
        report.add(topRow);
        report.addAll(tempReport);
        report.add("+ " + "-".repeat(longest1 + 3) + "-" + "-".repeat(topRow.length() - longest1 - 8) + " +");
        return report;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return false;
        } else if (amount > balance + limit) {
            System.out.println("Insufficient funds.");
            return false;
        } else {
            balance -= amount;
            System.out.println("Successfully withdrew " + String.format("$%.2f", amount) + " dollars.");
            log.add(new Transaction(amount, "Withdraw", balance+amount, balance));
            return true;
        }
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return false;
        }
        balance += amount;
        System.out.println("Successfully deposited " + String.format("$%.2f", amount) + " dollars.");
        log.add(new Transaction(amount, "Deposit", balance - amount, balance));
        return true;
    }
}