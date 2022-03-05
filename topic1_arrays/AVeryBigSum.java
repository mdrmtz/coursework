public class AVeryBigSum {

    /**
     * Your solution in here. Just need to add the number in a variable type long, so you
     * don't face overflow.
     */
    static long aVeryBigSum(int n, long[] ar) {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += ar[i];
        }
        return sum;
    }

    static long aVeryBigSum(long[] ar) {
        return aVeryBigSum(ar.length, ar);
    }

    /**
     * HackerRank provides this code.
     */
    public static void main(String[] args) {
        long[] ar = new long[]{1, 2, 3, 4, 5};
        long result = aVeryBigSum(ar.length, ar);
        System.out.println(result);
    }
}
