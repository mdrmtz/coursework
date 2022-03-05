import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuicksortPartI {

    public static List<Integer> quickSort(List<Integer> arr) {
        int pivotValue = arr.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for(int n : arr) {
            if (n < pivotValue) {
                left.add(n);
            } else {
                right.add(n);
            }
        }

        left.addAll(right);

        return left;
    }

    static int[] quickSort(int[] arr) {
        int pivotValue = arr[0];
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < pivotValue) {
                left.add(arr[i]);
            } else {
                right.add(arr[i]);
            }
        }
        printArray(left);
        System.out.print(pivotValue + " ");
        printArray(right);
        return new int[0];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int[] result = quickSort(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }

        System.out.println();

        QuicksortPartI.quickSort(List.of(8,2,3,4,5,7));
        in.close();
    }
    private static void printArray(List<Integer> ar) {
        for(int n: ar){
            System.out.print(n + " ");
        }
    }
}
