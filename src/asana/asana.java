/*
package asana;

import java.util.*;

public class asana {
    static char[][] board;

    static Combine[][] combine;

    static OrderCombine[][] orderCombine;

    public static class OrderCombine {
        Queue<Combine> queue;
    }

    public static class Combine {
        Key key;
        Group group;

        public Combine(Key key, Group g) {
            this.key = key;
            this.group = g;
        }
    }

    public static class Key {
        int p1x;
        int p1y;

        public Key(int p1y, int p1x) {
            this.p1x = p1x;
            this.p1y = p1y;
        }
    }

    public static class Group {
        int p1x;
        int p1y;
        int p2x;
        int p2y;
        char ch;

        public Group(char ch, int p1y, int p1x, int p2y, int p2x) {
            this.p1x = p1x;
            this.p1y = p1y;
            this.p2x = p2x;
            this.p2y = p2y;
            this.ch = ch;
        }
    }

    public static void main(String[] args) {
        board = new char[6][10];
        combine = new Combine[6][10];
        orderCombine = new OrderCombine[6][10];
        Arrays.fill(orderCombine, null);
        drawRectangle('R', 2, 1, 4, 4);
    }

    public static void dragAndDrop(int p1_y, int p1_x, int p2_y, int p2_x) {
        OrderCombine orderCombine = orderCombine[p1_y][p1_x];
        Combine combine = orderCombine.queue.poll();
        Group moveThis = combine.group;

        drawRectangle(moveThis.p1y, moveThis.p1x, moveThis.p2y, moveThis.p2x);
        eraseArea(moveThis.p1y, moveThis.p1x, moveThis.p2y, moveThis.p2x);
    }

    public static void drawRectangle(char ch, int p1_y, int p1_x, int p2_y, int p2_x) {
        Group g = new Group(ch, p1_y, p1_x, p2_y, p2_x);

        for (int i = p1_x; i <= p1_x; i++) {

            for (int j = p1_y; j <= p2_y; j++) {
                board[i][j] = ch;
                Key key = new Key(i, j);

                if (orderCombine[i][j] != null) {
                    OrderCombine orderCombine = orderCombine[i][j];
                    Queue<Combine> combine = orderCombine.queue;
                    queue.add(new Combine(key, g));
                } else {
                    OrderCombine orderCombine = new OrderCombine();
                    orderCombine.queue.add(new Combine(key, g));
                    orderCombine[i][j] = orderCombine;
                }
            }
        }

    }

    public static void eraseArea(int p1_y, int p1_x, int p2_y, int p2_x) {
        for (int i = p1_x; i <= p2_x; i++) {
            char[] chars = board[i];
            Arrays.fill(chars, p1_y, p2_y + 1, ' ');
        }

        for (int i = p1_x; i <= p2_x; i++) {
            OrderCombine[] orderComb = orderCombine[i];
            Arrays.fill(orderComb, p1_y, p2_y + 1, null);
        }
    }

    public static void bringToFront(int x, int y) {
        OrderCombine orderComb = orderCombine[x][y];
        Combine combine = orderComb.queue.peek();
        Group group = combine.group;

        drawRectangle(group.ch, group.p1y, group.p1x, group.p2y, group.p2x);
    }

    public static void printCanvas() {
        // Loop through all rows
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }


}
*/
