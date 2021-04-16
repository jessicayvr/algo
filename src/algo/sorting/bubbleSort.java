package algo.sorting;

// O(n^2)
public class bubbleSort {

    public static void main(String[] args) {
        int[] num = {1,4,0,2,3};
        bubbleSort(num);
        System.out.print(num);
    }

    public static void bubbleSort(int[] num) {

        // at the end of each loop, the biggest number will be on the right
        for(int i = 0; i < num.length-1; i++) {
            for (int j = 0; j < num.length-i-1; j++) {
                if (num[j] > num[j+1]) {
                    int temp = num[j];
                    num[j] = num[j+1];
                    num[j+1] = temp;
                }
            }
        }
    }
}
