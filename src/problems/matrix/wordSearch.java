package problems.matrix;

import java.util.Collections;

public class wordSearch {

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        boolean see = exist(board, "ABCCED");
        System.out.print(see);
    }

    private static boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (doDFS(i, j, board, word.substring(1), visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    //Space O(min (m * n, length of word))
    private static boolean doDFS(int i, int j, char[][] board, String word, boolean[][] visited) {

        if (word.length() == 0) {
            return true;
        }

        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int x = dx[k] + i;
            int y = dy[k] + j;

            if (x >=0 && y>=0&& x < board.length && y < board[0].length && board[x][y]== word.charAt(0) && !visited[x][y]) {
                if (doDFS(x,y, board, word.substring(1), visited)){
                    return true;
                }

            }
        }
        visited[i][j] = false;
        return false;
    }
}
