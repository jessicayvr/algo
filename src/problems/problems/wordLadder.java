package problems.problems;

import java.util.*;
import java.util.Queue;

/**
 * O(M×N), where M is word length and N list size.
 * Finding out all the transformations takes M iterations for each of the N words.
 * Also, breadth first search in the worst case might go to each of the NN words.
 */
public class wordLadder {

    public static void main(String[] args) {
        String begin = "hit";
        String end = "cog";

        // if theres no new ArrayList<> can't do remove operation
        List<String> dic = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.print(ladderLength(begin, end, dic));
    }

    private static class WordNode {
        String str;
        int val;

        public WordNode(String str, int val) {
            this.str = str;
            this.val = val;
        }
    }

    public static int ladderLength(String beginWord, String endWord, List<String> dict) {
        Queue<WordNode> q = new LinkedList<>();
        q.add(new WordNode(beginWord, 1));

        while (!q.isEmpty()) {
            WordNode poll = q.poll();
            String str = poll.str;
            int val = poll.val;

            if (str.equals(endWord)) {
                return val;
            }
            char[] chars = str.toCharArray();
            for (int i = 0 ; i < str.length(); i++) {

                char aChar = chars[i];
                for (char x = 'a'; x <= 'z'; x++) {
                    if (x == aChar) {
                        continue;
                    }
                    chars[i] = x;
                    String newStr = new String(chars);
                    if (dict.contains(newStr)) {
                        q.add(new WordNode(newStr, val +1));
                        dict.remove(newStr);
                    }
                }
                chars[i] = aChar;
            }
        }
        return 0;
    }

}
