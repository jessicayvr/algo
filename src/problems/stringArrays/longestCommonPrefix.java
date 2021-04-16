package problems.stringArrays;

/**
 * N = Number of strings
 * M = Length of the largest string string
 * O(NM)
 */
public class longestCommonPrefix {

    private static String longest(String[] arr) {
        return divideAndConquer(arr, 0, arr.length - 1);
    }

    private static String divideAndConquer(String[] arr, int low, int high) {
        if (low == high) {
            return arr[low];
        }

        int mid = (low + high) / 2;
        String left = divideAndConquer(arr, low, mid);
        String right = divideAndConquer(arr, mid + 1, high);

        return findPrefix(left, right);
    }

    private static String findPrefix(String str1, String str2) {
        int s1_length = str1.length();
        int s2_length = str2.length();

        int max_length = Math.min(s1_length, s2_length);

        StringBuilder x = new StringBuilder();
        for (int i = 0; i < max_length; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                break;
            }
            x.append(str1.charAt(i));
        }

        return x.toString();
    }

    public static void main(String[] args) {
        String[] arr = {"flower", "flow", "flight", "float"};
        String longest = longest(arr);
        System.out.println(longest);
    }
}
