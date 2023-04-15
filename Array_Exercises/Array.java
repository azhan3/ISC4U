package Array_Excercises;

import java.util.Scanner;
import java.util.Random;

public class Array {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        int min = getIntInput(input, "Enter minimum value: ");
        int max = getIntInput(input, "Enter maximum value: ");

        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(max - min + 1) + min;
        }

        System.out.print("Generated array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        int searchNum = getIntInput(input, "Enter number to search for: ");

        int index = linearSearch(arr, searchNum);

        if (index != -1) {
            System.out.println(searchNum + " was found at index " + index);
        } else {
            System.out.println(searchNum + " was not found in the array");
        }
    }

    public static int getIntInput(Scanner input, String prompt) {
        boolean isValidInput = false;
        int num = 0;
        while (!isValidInput) {
            System.out.print(prompt);
            if (input.hasNextInt()) {
                num = input.nextInt();
                isValidInput = true;
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                input.next();
            }
        }
        return num;
    }

    public static int linearSearch(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return i;
            }
        }
        return -1;
    }
}