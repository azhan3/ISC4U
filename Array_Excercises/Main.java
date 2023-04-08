package Array_Excercises;

public class Main {
    public static void main(String args[]) {
        int arr[] = { 90, 23, 101, 45, 65, 23, 67, 89, 34, 23 };
        Merge_Sort ob = new Merge_Sort();
        ob.sort(arr, 0, arr.length);
        for (int i : arr) System.out.print(i + " ");
    }
}
