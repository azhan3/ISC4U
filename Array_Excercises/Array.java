package Array_Excercises;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Array {

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        
        int min, max;
        System.out.print("Minimum: ");
        min = sc.nextInt();
        System.out.print("Maximum: ");
        max = sc.nextInt();
        
        int[] nums = new int[max - min + 1];

        for (int i = 0 ; i < nums.length ; ++i) {
            nums[i] = rand.nextInt(max - min + 1) + min;
        }
        System.out.println(Arrays.toString(nums));
    }
    
}
