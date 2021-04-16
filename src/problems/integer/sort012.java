package problems.integer;

public class sort012 {

        public static int[] sort(int[] n) {
            int low = 0;
            int high = n.length-1;
            int i = 0;

            while (i <= high) {
                if (n[i] == 2) {
                    swap(n,i,high);
                    high--;
                } else if (n[i] == 1) {
                    i++;
                } else if (n[i] == 0) {
                    swap(n, i, low);
                    low++;
                    i++;
                }
            }
            return n;
        }

        public static void swap(int[] n, int x, int y) {
            int temp = n[x];
            n[x] = n[y];
            n[y]= temp;
        }

    public static void main(String[] args) {

        int[] n = {2,0,2,1,1,0};

        int[] sorted = sort(n);
        for (int value : sorted) {
            System.out.print(value);
        }
    }
}