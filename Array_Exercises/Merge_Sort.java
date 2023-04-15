package Array_Exercises;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Merge_Sort {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();

    int min = getIntInput(sc, "Enter minimum value: ");
    int max = getIntInput(sc, "Enter maximum value: ");
    int arrSize = getIntInput(sc, "Enter array size: ");

    ArrayList<Integer> arrList = new ArrayList<Integer>();
    for (int i = 0; i < arrSize; i++) {
      arrList.add(rand.nextInt(max - min + 1) + min);
    }

    System.out.println("Unsorted ArrayList: " + arrList);

    mergeSort(arrList, 0, arrList.size() - 1);

    System.out.println("Sorted ArrayList: " + arrList);
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

  public static void mergeSort(ArrayList<Integer> arrList, int leftIndex, int rightIndex) {
    if (leftIndex < rightIndex) {

      int middleIndex = (leftIndex + rightIndex) / 2;

      mergeSort(arrList, leftIndex, middleIndex);
      mergeSort(arrList, middleIndex + 1, rightIndex);

      merge(arrList, leftIndex, middleIndex, rightIndex);

      ArrayList<Integer> leftHalf = new ArrayList<Integer>(arrList.subList(leftIndex, middleIndex + 1));
      ArrayList<Integer> rightHalf = new ArrayList<Integer>(arrList.subList(middleIndex + 1, rightIndex + 1));
      System.out.println("Splitting [" + leftIndex + "..." + rightIndex + "] into " + leftHalf + " and " + rightHalf);
      System.out.println("Merging [" + leftIndex + "..." + middleIndex + "] and [" + (middleIndex + 1) + "..."
          + rightIndex + "]: " + arrList);
    }
  }

  public static void merge(ArrayList<Integer> arrList, int leftIndex, int middleIndex, int rightIndex) {

    ArrayList<Integer> leftHalf = new ArrayList<Integer>(arrList.subList(leftIndex, middleIndex + 1));
    ArrayList<Integer> rightHalf = new ArrayList<Integer>(arrList.subList(middleIndex + 1, rightIndex + 1));

    int i = 0;
    int j = 0;
    int k = leftIndex;
    while (i < leftHalf.size() && j < rightHalf.size()) {
      if (leftHalf.get(i) < rightHalf.get(j)) {
        arrList.set(k, leftHalf.get(i));
        i++;
      } else {
        arrList.set(k, rightHalf.get(j));
        j++;
      }
      k++;
    }

    while (i < leftHalf.size()) {
      arrList.set(k, leftHalf.get(i));
      i++;
      k++;
    }

    while (j < rightHalf.size()) {
      arrList.set(k, rightHalf.get(j));
      j++;
      k++;

    }
  }
}