package Array_Excercises;

import java.util.*;

public class Merge_Sort {
    public static void mergeSort(int[] array) {
        if (array.length > 1) {
          int mid = array.length / 2;
          int[] leftArray = Arrays.copyOfRange(array, 0, mid);
          int[] rightArray = Arrays.copyOfRange(array, mid, array.length);
          mergeSort(leftArray);
          mergeSort(rightArray);
          merge(array, leftArray, rightArray);
        }
      }
      
      public static void merge(int[] array, int[] leftArray, int[] rightArray) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < leftArray.length && j < rightArray.length) {
          if (leftArray[i] <= rightArray[j]) {
            array[k] = leftArray[i];
            i++;
          } else {
            array[k] = rightArray[j];
            j++;
          }
          k++;
        }
        while (i < leftArray.length) {
          array[k] = leftArray[i];
          i++;
          k++;
        }
        while (j < rightArray.length) {
          array[k] = rightArray[j];
          j++;
          k++;
        }
      }
}