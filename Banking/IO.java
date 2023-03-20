package Banking;
import java.util.Scanner;

public class IO {
    Scanner sc = new Scanner(System.in);
    public int getOption() {
        int num;
        while (true) {
            try { 
                System.out.print("Enter an Option: "); 
                num = Integer.parseInt(sc.nextLine()); 
                return num;
            } catch (NumberFormatException nfe) { 
                System.err.println("Error! Please enter a valid option!");
            }
        }
    }
}
