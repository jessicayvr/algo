package problems.integer;

public class minSwaps {
    public static void main(String[] args) {
        minimumSwap("xy", "yx");
    }

    public static int minimumSwap(String s1, String s2) {
        int moves = 0, x1 = 0, x2 = 0, mismatch = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                mismatch++;
                if (s1.charAt(i) == 'x') {
                    x1++;
                } else {
                    x2++;
                }
            }
        }

        // if we have an even number of x and ys then min swap is num of xy/2
        if (mismatch % 2 != 0) return -1;
        //since 1 swap can cancel out 2 differences, we only need difference / 2 swaps.
        moves += x1 / 2 + x2 / 2;
        // all remaining mismatches have x's on opposite sides (xy, yx), they cost one swap per x, as in example 2
        moves += x1 % 2 + x2 % 2;
        return moves;
    }
}
