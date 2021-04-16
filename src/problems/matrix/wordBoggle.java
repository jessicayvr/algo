package problems.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class wordBoggle {

    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.print(doBoggle(board, words));
    }

    private static List<String> doBoggle(char[][] m, String[] words) {
        List<String> dict = new ArrayList<>(Arrays.asList(words));
        List<String> result = new ArrayList<>();
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                boolean[][] visited = new boolean[m.length][m[0].length];
                String x = "";
                findWords(i, j, m, visited, dict, "", result);
            }
        }
        return result;
    }

    private static void findWords(int i, int j, char[][] m, boolean[][] visited, List<String> dict, String str, List<String> result) {
        visited[i][j] = true;
        str = str + m[i][j];

        String finalStr = str;
        if (dict.stream().anyMatch(x -> x.startsWith(finalStr))) {

            if (dict.contains(str)) {
                result.add(str);
                dict.remove(str);
            }

            int[] dx = new int[]{-1, 0, 1, 0};
            int[] dy = new int[]{0, 1, 0, -1};

            for (int k = 0; k < 4; k++) {
                int x = dx[k] + i;
                int y = dy[k] + j;

                if (x >= 0 && y >= 0 && x < m.length && y < m[0].length && !visited[x][y]) {
                    findWords(x, y, m, visited, dict, str, result);
                }
            }
        }
        visited[i][j] = false;
        // don't need because String is immutable;
        // str = str.substring(0,str.length()-1);
    }


}
