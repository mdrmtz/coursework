import java.util.Arrays;

public class MergeSort {
    static void sort(int[] arr) {
        sort(arr, new int[arr.length], 0, arr.length - 1);
    }

    private static void sort(int[] arr, int[] tmp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) {
            return;
        }

        int middle = (leftStart + rightEnd) / 2;
        sort(arr, tmp, leftStart, middle);
        sort(arr, tmp, middle + 1, rightEnd);
        merge(arr, tmp, leftStart, rightEnd);

    }

    private static void merge(int[] arr, int[] tmp, int leftStart, int rightEnd) {
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            if (arr[left] < arr[right]) {
                tmp[index] = arr[left];
                left++;
            } else {
                tmp[index] = arr[right];
                right++;
            }
            index++;
        }

        System.arraycopy(arr, left, tmp, index, leftEnd - left + 1);
        System.arraycopy(arr, right, tmp, index, rightEnd - right + 1);
        System.arraycopy(tmp, leftStart, arr, leftStart, size );

    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 4, 5, 3, 1, 9, 6, 0, 12, 7};
        MergeSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
