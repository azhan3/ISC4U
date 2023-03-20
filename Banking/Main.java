package Banking;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {
    
    public static void main(String[] args) {
        Record_Accounts record = new Record_Accounts();
        IO banger = new IO();
        Scanner sc = new Scanner(System.in);
        Account current_account;
        record.Add_Account(new Account());
        current_account = record.Get_Account(record.Get_Length() - 1);
        System.out.printf("Successfully added Account %s\n", current_account.getName());
        do {
            System.out.printf("\033[4m%s's Account\033[0m\n1: Add Account\n2: Change Account\n3: Withdraw\n4: View Account Balance\n5: Deposit\n6: Transaction History\n7: Exit\n", current_account.getName());
            int op = banger.getOption();
            System.out.println();
            switch(op) {
                case 1:
                    record.Add_Account(new Account());
                    current_account = record.Get_Account(record.Get_Length() - 1);
                    System.out.printf("Successfully added Account %s\n", current_account.getName());
                    System.out.printf("Now viewing %s's account\n", current_account.getName());
                    break;
                case 2:
                    System.out.println("Select an account from the list:");
                    for (int i = 0 ; i < record.Get_Length() ; ++i ) {
                        System.out.println(Integer.toString(i + 1) + ": " + record.Get_Account(i).getName());
                    }
                    System.out.print("Option: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Please Enter an Integer!");
                        break;
                    }
                    int selection = sc.nextInt();
                    
                    if (selection <= 0 || selection > record.Get_Length()) {
                        System.out.println("Please Enter a Valid Option!");
                    } else {
                        current_account = record.Get_Account(selection-1);
                        System.out.printf("Now using %s's account\n", current_account.getName());
                    }
                    break;

                case 3:
                    System.out.print("How much would you like to withdraw: ");
                    if (!sc.hasNextDouble()) {
                        System.out.println("Please Enter a Number!");
                        break;
                    }
                    current_account.withdraw(sc.nextDouble());
                    break;
                case 4:
                    System.out.printf("Your Balance is: %s\n", current_account.getBalance());
                    break;
                case 5:
                    System.out.print("How much would you like to deposit: ");
                    if (!sc.hasNextDouble()) {
                        System.out.println("Please Enter a Number!");
                        break;
                    }
                    current_account.deposit(sc.nextDouble());
                    break;
                case 6:
                    for (String element : current_account.rep()) {
                        System.out.println(element);
                    }
                    break;
                case 7:
                    System.out.println("Have a Great Day!");
                    break;    
                default:
                    System.out.println("Please Enter a Valid Option!");
                    
            }
            System.out.println();
        } while (true);
    }

    

}