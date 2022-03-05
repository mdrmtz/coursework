import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class MigratoryBirdsTest {

    @Test
    void migratoryBirds() {
        Assertions.assertEquals(MigratoryBirds.migratoryBirds(List.of(1, 4, 4, 4, 5, 3)), 4);
        Assertions.assertEquals(MigratoryBirds.migratoryBirds(List.of(1,2, 3, 4, 5, 4, 3, 2, 1, 3, 4)), 3);
        Assertions.assertEquals(MigratoryBirds.migratoryBirds(List.of(1, 1, 2, 2, 3)), 1);
    }
}