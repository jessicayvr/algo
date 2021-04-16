package problems.stringArrays;

public class repeatedSubstringPattern {
    public static void main(String[] args) {
        String str = "abcaabcaabcaabca";
        System.out.print(repeatedSubstringPattern(str));
    }

    // find next index of the first character
    public static boolean repeatedSubstringPattern(String str) {
        int length = str.length();

        char first = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == first) {
                String substring = str.substring(0, i);
                int subLength = substring.length();
                int times = length / subLength;

                //make performance faster
                if (length % subLength != 0 ) {
                    continue;
                }

                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < times; k++) {
                    sb.append(substring);
                }
                if (sb.toString().equals(str)) {
                    return true;
                }

            }
        }
        return false;
    }
}
