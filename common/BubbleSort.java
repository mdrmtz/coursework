import java.util.Arrays;

public class BubbleSort {

    static void sort(int[] arr) {
        boolean isSorted = false;
        int lastUnsorted = arr.length - 1;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < lastUnsorted; i++) {
                if (arr[i] > arr[i + 1]) {
                    arr[i] = arr[i] ^ arr[i + 1];
                    arr[i + 1] = arr[i] ^ arr[i + 1];
                    arr[i] = arr[i] ^ arr[i + 1];
                    isSorted = false;
                }
            }
            lastUnsorted--;
        }
    }

    // An optimized version of Bubble Sort
    static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j] and arr[j+1]
                    arr[j] = arr[j] ^ arr[j + 1];
                    arr[j + 1] = arr[j] ^ arr[j + 1];
                    arr[j] = arr[j] ^ arr[j + 1];
                    swapped = true;
                }
            }

            // IF no two elements were
            // swapped by inner loop, then break
            if (!swapped)
                break;
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 4, 5, 3, 1, 9, 6};
        BubbleSort.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(BubbleSort.bubbleSort(new int[]{2, 4, 5, 3, 1, 9, 6})));
    }
}
