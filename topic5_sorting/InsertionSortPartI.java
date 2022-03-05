import java.util.List;
import java.util.Scanner;

public class InsertionSortPartI {

    public static void insertionSort1(int n, List<Integer> arr) {
        int elementToSort = arr.get(n-1);

        for(int currentIndex=n-2; currentIndex>=0; currentIndex--) {
            //copy the value at the lower index to
            //the current index and print your array.
            int value = arr.get(currentIndex);

            arr.set(currentIndex + 1, Math.max(value, elementToSort));

            printArray(arr);
        }
    }

    static void insertionSort1(int n, int[] arr) {
        int elementToSort = arr[arr.length - 1];
        int index = arr.length - 1;
        while (index > 0) {
            if (arr[index - 1] < elementToSort) {
                break;
            }
            arr[index] = arr[index - 1];
            printArray(arr);
            index--;
        }
        arr[index] = elementToSort;
        printArray(arr);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        insertionSort1(n, arr);
        in.close();
    }

    private static void printArray(int [] arr) {
        for (int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    private static void printArray(List<Integer> list) {
        for(Integer n: list){
            System.out.print(n + " ");
        }

        System.out.println();
    }
}
