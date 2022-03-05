import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AVeryBigSumTest {
    @Test
    void aVeryBigSum() {
        long[] ar = new long[]{1, 2, 3, 4, 5};
        Assertions.assertEquals(AVeryBigSum.aVeryBigSum(ar.length, ar), 15);
        Assertions.assertEquals(AVeryBigSum.aVeryBigSum(5, new long[]{1000000001, 1000000002, 1000000003, 1000000004, 1000000005}), 5000000015L);
        Assertions.assertEquals(AVeryBigSum.aVeryBigSum(0, new long[0]), 0);

        Assertions.assertEquals(AVeryBigSum.aVeryBigSum(ar), 15);
        Assertions.assertEquals(AVeryBigSum.aVeryBigSum(new long[]{1000000001, 1000000002, 1000000003, 1000000004, 1000000005}), 5000000015L);
        Assertions.assertEquals(AVeryBigSum.aVeryBigSum(new long[0]), 0);
    }
}