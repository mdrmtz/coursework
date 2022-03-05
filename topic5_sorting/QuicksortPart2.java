import java.util.Scanner;

public class QuicksortPart2 {
    static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = arr[left];
            int pi = partition(arr, pivot, left, right);
            quickSort(arr, left, pi - 1);
            quickSort(arr, pi + 1, right);
            printArray(arr, left, right);
        }
    }

    static int partition(int[] arr, int pivot, int left, int right) {
        int index = left + 1;
        int pivotPosition = left, e;
        while (index <= right) {
            if (arr[index] < pivot) {
                e = arr[index];
                //if (index - pivotPosition >= 0)
                //System.arraycopy(arr, pivotPosition, arr, pivotPosition + 1, index - pivotPosition);
                for (int j = index - 1; j >= pivotPosition; j--)
                    arr[j + 1] = arr[j];
                arr[pivotPosition] = e;
                pivotPosition++;
            }
            index++;
        }

        return pivotPosition;
    }

    static void printArray(int[] arr, int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = in.nextInt();

        quickSort(arr, 0, n - 1);
        in.close();
    }
}