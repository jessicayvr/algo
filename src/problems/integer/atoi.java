package problems.integer;

public class atoi {

    public static void main(String[] args) {
        String x = "words and 987";
        System.out.print(doAtoi(x));
    }

    private static int doAtoi(String str) {
        int i = 0;

        for (int k=0; k < str.length(); k++) {
            if (str.charAt(k) == ' ') {
                i++;
            } else {
                break;
            }
        }

        if ('a' <= str.charAt(i) && str.charAt(i) <= 'z') {
            return 0;
        }

        int sign = 1;
        if (str.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (str.charAt(i) == '+') {
            sign = 1;
            i++;
        }

        String s = str.substring(i);
        String[] strings = s.split(" ");
        String num = strings[0];

        int result = 0;
        for (int j = 0 ; j < num.length(); j++) {
            int x = num.charAt(j) - '0';
            result = result * 10 + x;
        }
        return result * sign;
    }
}
