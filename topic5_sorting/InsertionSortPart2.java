import java.util.Scanner;

public class InsertionSortPart2 {

    // In this exercise I am going to reuse the method that I wrote for the part2.
    // I will modify n (the further most to the right element to consider).
    static void insertionSort2(int n, int[] arr) {
        // It doesn't make sense to start at index 0, as we will not
        // need to move anything.
        for (int i = 1; i < arr.length; i++) {
            insertionSort1(i, arr);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        insertionSort2(n, arr);
        in.close();
    }

      static void insertionSort1(int n, int[] arr) {
        int elementToSort = arr[n];
        int index = n;
        while (index > 0) {
            if (arr[index - 1] < elementToSort) {
                break;
            }
            arr[index] = arr[index - 1];
            // printArray(arr); Now we don't need to print here.
            index--;
        }
        arr[index] = elementToSort;
        printArray(arr);
    }

    private static void printArray(int [] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}
