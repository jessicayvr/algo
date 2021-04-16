package amazon;

import java.util.*;

/**
 * Print all shortest path
 *   ["hit","hot","dot","dog","cog"],
 *   ["hit","hot","lot","log","cog"]
 */
public class wordLadderII {

    // do workLadderI (BFS)
    // now you know the shortest length, do DFS check if result is < shortest length
    public static void main(String[] args) {
        String begin = "hit";
        String end = "cog";
        Set<String> dic = new HashSet<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));

        List<List<String>> i =doWordLadder(begin, end, dic);
        System.out.println(i);
    }

    public static class Word {
        private String str;
        private int val;
        private List<String> result = new ArrayList<>();
        private List<String> visited;

        public Word(String str, int val, List<String> visited, List<String> result) {
            this.str = str;
            this.val = val;
            this.visited = visited;
            this.result = result;
        }

        private String getStr() {
            return this.str;
        }

        private int getVal() {
            return this.val;
        }

        private List<String> getVisited() {
            return this.visited;
        }

        private List<String> getResult() {
            return this.result;
        }

    }

    private static List<List<String>> doWordLadder(String begin, String end, Set<String> dic) {
        Queue<Word> q = new LinkedList<>();
        q.add(new Word(begin, 1, new ArrayList<>(), new ArrayList<>(Arrays.asList(begin))));
        List<List<String>> result = new ArrayList<>();

        while (!q.isEmpty()) {
            Word poll = q.poll();
            String str = poll.getStr();
            int val = poll.getVal();

            if (str.equals(end)) {
                result.add(poll.result);
            }

            for (int i = 0; i < str.length(); i++) {
                char original = str.charAt(i);
                char[] chars = str.toCharArray();
                for (char x = 'a'; x < 'z'; x++) {
                    if (x != original) {
                        chars[i] = x;
                        String newWord = new String(chars);
                        if (dic.contains(newWord) && !poll.visited.contains(newWord)) {
                            List<String> result1 = new ArrayList<>(poll.result);
                            result1.add(newWord);

                            List<String> visited = new ArrayList<>(poll.visited);
                            visited.add(newWord);
                            q.add(new Word(newWord, val + 1, visited, result1));
                        }
                        chars[i] = original;
                    }
                }
            }
        }

        return result;
    }
}
