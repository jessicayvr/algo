package problems.problems;

import java.util.HashMap;
import java.util.HashSet;

public class soduko {

    public static void main(String[] args) {
       char[][] board = new char[][]{
               {'5','3','.','.','7','.','.','.','.'},
               {'6','.','.','1','9','5','.','.','.'},
               {'.','9','8','.','.','.','.','6','.'},
               {'8','.','.','.','6','.','.','.','3'},
               {'4','.','.','8','.','3','.','.','1'},
               {'7','.','.','.','2','.','.','.','6'},
               {'.','6','.','.','.','.','2','8','.'},
               {'.','.','.','4','1','9','.','.','5'},
               {'.','.','.','.','8','.','.','7','9'}
       };

       System.out.print(isValidSudoku(board));
    }
    public static boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Integer>> col = new HashMap();
        HashMap<Integer, HashSet<Integer>> row = new HashMap();
        HashMap<Integer, HashSet<Integer>> box = new HashMap();

        for (int i = 0 ; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if ( c == '.') {
                    continue;
                }

                int num = Integer.parseInt(String.valueOf(c));
                // do col
                if (col.getOrDefault(j, new HashSet<>()).contains(num)) {
                    return false;
                } else {
                    HashSet<Integer> temp = col.getOrDefault(j, new HashSet<>());
                    temp.add(num);
                    col.put(j, temp);
                }

                // do row
                if (row.getOrDefault(i, new HashSet<>()).contains(num)) {
                    return false;
                } else {
                    HashSet<Integer> temp = row.getOrDefault(i, new HashSet<>());
                    temp.add(num);
                    row.put(i, temp);
                }

                // do box
                int b = 3 * (i/3) + (j/3);
                if (box.getOrDefault(b, new HashSet<>()).contains(num)) {
                    return false;
                } else {
                    HashSet<Integer> temp = box.getOrDefault(b, new HashSet<>());
                    temp.add(num);
                    box.put(b, temp);
                }
            }
        }
        return true;
    }
}
