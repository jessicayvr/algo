package problems.twoPointers;

public class isSubsequence {
    public static void main(String[] args) {
        isSubsequence("abc", "ahbgdc");
    }

    public static boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) {
            return true;
        } else if (t == null || t.length() == 0) {
            return false;
        }
        int index = 0;
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(index) == t.charAt(i)) {
                index++;

                if (index == s.length()) {
                    return true;
                }
            }
        }
        return index == s.length();
    }
}
