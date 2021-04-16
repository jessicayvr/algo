package problems.integer;

public class rotateArrayK {

    // O(n) three times
    // O(1) no space used
    public static void main(String[] args) {
        int [] n = new int[] {1,2,3,4,5,6,7};
        int k = 3;

        rotate(n,k);

        System.out.print(n);
    }

    // reverse list 7,6,5,4,3,2,1
    // reverse 1-k  5,6,7  ,4,3,2,1
    // reverse k-end   5,6,7,  1,2,3,4
    private static void rotate(int[] n, int k) {
        reverse(n, 0, n.length-1);
        reverse(n, 0, k-1);
        reverse(n, k, n.length-1);
    }

    private static void reverse(int[] n, int left, int right) {
        while (left < right) {
            int temp = n[right];
            n[right] = n[left];
            n[left] = temp;
            left++;
            right--;
        }
    }
}
