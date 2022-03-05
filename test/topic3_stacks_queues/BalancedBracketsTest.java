import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BalancedBracketsTest {

    @Test
    void isBalanced() {
        Assertions.assertTrue(BalancedBrackets.isBalanced("{[()]}"));
        Assertions.assertTrue(BalancedBrackets.isBalanced("{[(])}"));
        Assertions.assertTrue(BalancedBrackets.isBalanced("{{[[(())]]}}"));
        Assertions.assertFalse(BalancedBrackets.isBalanced("))))(((("));
    }
}