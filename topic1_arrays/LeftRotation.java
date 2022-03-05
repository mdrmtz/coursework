import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LeftRotation {

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        int n = arr.size();
        return Stream.concat(arr.subList(d,n).stream(), arr.subList(0,d).stream())
                .collect(Collectors.toList());
    }

    static int[] leftRotation(int[] a, int d) {

        /*
        *
        *
        *
                             *
        // Creating temp array of size d
        // Copying first d element in array temp
        List<Integer> temp = new ArrayList<>(arr);

        // Moving the rest element to index
        // zero to N-d
        for (int i = d; i < n; i++) {
            arr.set(i - d , arr.get(i));
        }

        // Copying the temp array element
        // in original array
        for (int i = 0; i < d; i++) {
            arr.set(i + n - d, temp.get(i));
        }

        return arr;
        * */
        // They say in requirements that these inputs should not be considered.
        // However, noting that we should prevent against those.
        if (d == 0 || a.length == 0) {
            return a;
        }

        int rotation = d % a.length;
        if (rotation == 0) return a;

        // Please note that there is an implementation, circular arrays that could be considered here,
        // but that one has an edge case (Test#1)
        // As, we don't need to optimize for memory, let's keep it simple.
        int [] b = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            b[i] = a[indexHelper(i + rotation, a.length)];
        }
        return b;
    }

    /**
    * Takes care of the case where the rotation index. You have to take into account
    * how it is rotated towards the left. To compute index of B, we rotate towards the right.
    * If we were to do a[i] in the loop, then this method would need to be slightly changed
    * to compute index of b.
    */
    private static int indexHelper(int index, int length) {
        if (index >= length) {
            return index - length;
        } else {
            return index;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] result = leftRotation(a, d);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println();


        in.close();
    }
}
