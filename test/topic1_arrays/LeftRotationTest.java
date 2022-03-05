import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class LeftRotationTest {

    @Test
    void rotateLeft() {
        Assertions.assertEquals(LeftRotation.rotateLeft(4, List.of(1,2,3,4,5)), List.of(5,1,2, 3, 4));
    }

    @Test
    void leftRotation() {
        Assertions.assertArrayEquals(LeftRotation.leftRotation(new int[]{1, 2, 3, 4 ,5}, 4), new int[]{5, 1, 2, 3, 4});
    }
}