package problems.stringArrays;

public class strStr {
     public static void main(String[] args) {

        String hay = "hello";
        String needle = "ll";
         int i = strStr(hay, needle);
         System.out.print(i);
     }
    public static int strStr(String haystack, String needle) {
         int i;
        for (i = 0; i < haystack.length(); i++) {
            int x = i;
            for (int j = 0; j < needle.length() && x < haystack.length(); j++) {
                if (haystack.charAt(x) == needle.charAt(j)) {
                    x++;
                    if (j == needle.length()-1) {
                        return i;
                    }
                } else {
                    break;
                }
            }
        }
        return -1;

    }
}
