import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*

For Given Number N find if its COLORFUL number or not

Return 0/1

COLORFUL number:

A number can be broken into different contiguous sub-subsequence parts.
Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different
Example:

N = 23
2 3 23
2 -> 2
3 -> 3
23 -> 6
this number is a COLORFUL number since product of every digit of a sub-sequence are different.

Output : 1
 */
public class ColorfulNumber {

    public int isColorful(int a) {
        Set<Long> st = new HashSet<>();
        String s = String.valueOf(a);

        for (int i = 0; i < s.length(); i++) {
            long product = 1;
            for (int j = i; j < s.length(); j++) {
                // convert string "3" into 3 number.
                int n = s.charAt(j) - '0';
                product *= n;

                if (st.contains(product)) {
                    return 0;
                }

                st.add(product);
            }
        }
        return 1;
    }

    public int colorful(int A) {
        // First let's create a collection of all the items that we need to evaluate
        // the product of.
        // In order to do this, I am going to put each of the digits in
        // an array

        int mod;
        int remaining = A;

        int index;
        List<Integer> digits = new ArrayList<>();

        while (remaining > 0) {
            mod = remaining % 10;
            remaining /= 10;
            digits.add(mod);
        }

        // Now we want to iterate it in such a way that 1st we look at it individually.
        // Then by pairs, then by group of 3 ... up until digits.size().
        // Each time we will add it to a set.
        // Warning they are sorted in a reverse way, so we start iterating from
        // the end.

        // NOTE: after I built this solution, I saw that it could be simplified
        // by just having the loop with the j go all the way down. After all we
        // have to accumulate all of the multipliers. Don't be fooled, even if
        // you look at a solution and it looks really simple, in programming
        // simplicity is the hardest, and can only be achieved after you master
        // your skills :)
        Set<Integer> productsStore = new HashSet<>();
        int groupingOf = 1;
        while (groupingOf <= digits.size()) {
            for (int i = digits.size() - 1; i >= 0; i--) {
                int product = digits.get(i);
                boolean outOfBound = false;
                for (int j = i - 1; j >= i - (groupingOf - 1); j--) {
                    // Let's protect against the ArrayIndexOutOfBound
                    if (j < 0) {
                        outOfBound = true;
                        break;
                    }

                    product *= digits.get(j);
                }

                // Now, if it already exists, then just return false, otherwise
                // Add it to the set collection and keep looking.
                if (productsStore.contains(product) && !outOfBound) {
                    return 0;
                } else {
                    productsStore.add(product);
                }
            }

            groupingOf++;
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(new ColorfulNumber().colorful(3245));
        System.out.println(new ColorfulNumber().colorful(23));
        System.out.println(new ColorfulNumber().colorful(10));
        System.out.println(new ColorfulNumber().isColorful(3245));
        System.out.println(new ColorfulNumber().isColorful(23));
        System.out.println(new ColorfulNumber().isColorful(10));
    }
}
