package design;

import problems.HelperUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class game2048 {
    public static Random r = new Random();
    public static int[][] grid;

    public static void main(String[] args) {
        grid = new int[4][4];
        placeNumber(2);
        placeNumber(2);
        HelperUtil.printMatrix(grid);


    }

//    public static void startGame() {
//        while (!isGameOver() || !gameWon()) {
//            boolean flipped = false;
//            boolean rotated = false;
//            switch (keyCode) {
//                case DOWN_ARROW:
//                    // do nothing
//                    break;
//                case UP_ARROW:
//                    grid = flipGrid(grid);
//                    flipped = true;
//                    break;
//                case RIGHT_ARROW:
//                    grid = transposeGrid(grid);
//                    rotated = true;
//                    break;
//                case LEFT_ARROW:
//                    grid = transposeGrid(grid);
//                    grid = flipGrid(grid);
//                    rotated = true;
//                    flipped = true;
//                    break;
//                default:
//                    played = false;
//            }
//
//
//            int[][] past = copyGrid(grid);
//            for (let i = 0; i < 4; i++) {
//                grid[i] = operate(grid[i]);
//            }
//            let changed = compare(past, grid);
//            if (flipped) {
//                grid = flipGrid(grid);
//            }
//            if (rotated) {
//                grid = transposeGrid(grid);
//            }
//            if (changed) {
//                addNumber();
//            }
//        }
//    }

    private static void makeMove() {
        for (int i = 0; i < 4; i++) {
            grid[i] = move(grid[i]);
        }
    }

    private static int[] move(int[] row) {
        row = combine(row);
        row = slide(row);
        return row;
    }


    private static int[] combine(int[] row) {
        int prev = -1;
        for (int i = 0; i < 3; i++) {
            if (prev == -1) {
                prev = i;
                continue;
            }
            if (row[i] == row[prev]) {
                row[prev] = row[i] + row[i];
                prev = -1;
                row[i] = 0;
            } else {
                prev = i;
            }
        }
        return row;
    }

    private static boolean placeNumber(int num) {
        List<int[]> openSpots = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (grid[i][j] == 0) {
                    openSpots.add(new int[]{i, j});
                }
            }
        }
        if (openSpots.isEmpty()) {
            return false;
        }
        int randomIndex = r.nextInt(openSpots.size());
        int[] ints = openSpots.get(randomIndex);
        if (num != 0) {
            grid[ints[0]][ints[1]] = num;
        } else {
            grid[ints[0]][ints[1]] = r.nextInt(10) >= 6 ? 2 : 4;
        }
        return true;
    }

    //always slides to the left
    public static int[] slide(int[] row) {
        //  int[] row = new int[] {0,2,0,4};
        int[] res = new int[4];
        int count = 0;
        // add number to the left;
        for (int i = 0; i < row.length; i++) {
            if (row[i] != 0) {
                res[count] = row[i];
                count++;
            }
        }

        // add rest of zeros
        for (int i = count; i < 4; i++) {
            res[count] = 0;
        }

        return res;
    }
}
