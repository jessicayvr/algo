package problems.integer;

public class globalLocalInversion {

    public static void main(String[] args) {
        int[] n = new int[]{2, 0, 3, 1};
        isIdealPermutation(n);
    }

    public static boolean isIdealPermutation(int[] n) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n.length - 2; i++) {
            // need max so far
            // ex (2 > n[2]{3}) == but 2 is a global inversion for n[3] {1};
            max = Math.max(max, n[i]);
            if (max > n[i + 2]) {
                return false;
            }
        }
        return true;
    }
}
