import jdk.nashorn.internal.AssertsEnabled;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class TestTest {
    @Test
    public void BestTimeToBuyStockTest() {
        // stock prices on consecutive days
        int price[] = {100, 100, 100};
        int n = price.length;

        int p[] = {100, 180, 310, 200, 40, 60};
        bestTimeToBuyStockProfit(price, price.length);
        bestTimeStock(price, price.length);
//        bestTime(price);
//
//        bestTimeToBuyStockProfit(p, p.length);
//        bestTime(p);
    }

    @Test
    void LongestCommonSubstring() {
        String str1 = "CLCL";
        String str2 = "LCLC";
        getLongestSubstring(str1, str2);
    }

    @Test
    void kpairSmallestSum() {
        int[] x = {1, 3, 5};
        int[] y = {7, 9, 10};
        smallestPair(x, y, 9);
    }

    @Test
    void shortestWordDistance() {
        String[] words = {"hello", "bye", "morning", "afternoon", "evening", "breakfast", "lunch", "dinner"};
        String w1 = "lunch";
        String w2 = "bye";
        System.out.println(findShortest(words, w1, w2));
    }

    @Test
    void rotateArray() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 2;
        int[] copy = rotateArray(arr, k);
        for (int i = 0; i < copy.length; i++) {
            System.out.println(copy[i]);
        }

        int[] secondCopy = rotateInPlaceArray(arr, k);
        for (int i = 0; i < secondCopy.length; i++) {
            System.out.println(secondCopy[i]);
        }


    }

    @Test
    void perm() {
        String str = "ABC";
        int n = str.length();
        permute(str, 0, n - 1);
    }

    private void permute(String str, int start, int last) {
        System.out.println("perm recur: " + "str = " + str + "  start = " + start);
        if (start == last)
            System.out.println(str);
        else {
            for (int i = start; i <= last; i++) {
                System.out.println("i = " + i + "   start = " + start);
                str = swap(str, start, i);
                System.out.println("after first swap: " + str);
                permute(str, start + 1, last);

                System.out.println("After perm recur" + "i = " + i + " +  start = " + start);
                str = swap(str, start, i);
                System.out.println("after second swap: " + str);
            }
        }
    }

    public String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    private int[] rotateInPlaceArray(int[] arr, int k) {

        int cut = arr.length - k;

        arr = reverse(arr, cut, arr.length - 1);
        arr = reverse(arr, 0, cut - 1);
        arr = reverse(arr, 0, arr.length - 1);

        return arr;
    }

    private int[] reverse(int[] arr, int cut, int end) {
        while (cut < end) {
            int temp = arr[cut];
            arr[cut] = arr[end];
            arr[end] = temp;
            cut++;
            end--;
        }
        return arr;
    }

    private int[] rotateArray(int[] arr, int k) {
        int[] copy = new int[arr.length];
        int j = arr.length - k;
        for (int i = 0; i < k; i++) {
            copy[i] = arr[j];
            j++;
        }
        j = 0;
        for (int i = k; i < arr.length; i++) {
            copy[i] = arr[j];
            j++;
        }
        return copy;
    }

    private int findShortest(String[] words, String w1, String w2) {
        int n = -1;
        int m = -1;
        int min = -1;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.equals(w1)) {
                n = i;
                if (m != -1) {
                    min = Math.abs(n - m);
                }
            } else if (word.equals(w2)) {
                m = i;
                if (n != -1) {
                    min = Math.abs(m - n);
                }

            }
        }
        return min;
    }

    public static void smallestPair(int[] x, int[] y, int k) {
        int count = 1;
        List<int[]> result = new ArrayList<>();

        int i = 0;
        int j = 0;
        int n = i;
        int m = j;
        int[] pair;
        pair = new int[]{x[0], y[0]};
        result.add(pair);
        while (i < x.length && j < y.length && n < x.length && m < y.length && count < k) {

            if (x[i] + y[m + 1] >= x[n + 1] + y[j]) {
                pair = new int[]{x[n + 1], y[j]};
                result.add(pair);
                n++;
                if (n + 1 == x.length) {
                    j++;
                    n = 0;
                }
            } else {
                pair = new int[]{x[i], y[m + 1]};
                result.add(pair);
                m++;

                if (m + 1 == y.length) {
                    i++;
                    m = 0;
                }
            }
            count++;
        }
        for (int[] p : result) {
            System.out.println("[ " + p[0] + ", " + p[1] + " ]");
        }
    }

    public static void getLongestSubstring(String str1, String str2) {
        int[][] dp = new int[str1.length()][str2.length()];

        int result = 0;
        List<String> strings = null;
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    }
                    if (result < dp[i][j]) {
                        result = dp[i][j];
                        strings = new ArrayList<>(Arrays.asList(str1.substring(i - result + 1, i + 1)));
                    } else if (result == dp[i][j]) {
                        strings.add(str1.substring(i - result + 1, i + 1));
                    }
                }

            }
        }

        for (String strs : strings) {
            System.out.println(strs);
        }
    }

    @Test
    public void NearestOneTest() {
        int mat[][] = {{0, 0, 0, 1}};

        printDistance(mat);

    }

    class Interval {
        int buy, sell;
    }

    public static void printDistance(int m[][]) {
        int result = 0;

        int[][] dp = new int[m.length][m[0].length];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] == 0) {
                    dp[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {

                dp[i][j] = helper(m, dp, i, j, i, j);
            }
        }

    }

    private static int helper(int[][] m, int[][] dp, int i, int j, int curX, int curY) {
        if (dp[i][j] > -1) {
            return dp[curX][curY];
        }


        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int k = 0; k < 4; k++) {
            int x = dx[k] + curX;
            int y = dy[k] + curY;

            if (x >= 0 && y >= 0 && y < m[0].length && x < m.length) {
                if (m[x][y] == 1) {
                    dp[i][j] = // Math.min(dp[i][j],
                            Math.abs(i - x) + Math.abs(j - y);
                } else {
                    dp[i][j] = Math.min(dp[curX][curY], helper(m, dp, i, j, x, y));
                }
            }
        }

        return dp[i][j];
    }


    public void bestTime(int[] price) {

        if (price.length < 1) {
            return;
        }

        int min = 0;
        int max = 0;

        ArrayList<Interval> buySell = new ArrayList<>();
        for (int i = 1; i < price.length; i++) {

            if (price[min] <= price[i] && price[max] < price[i]) {
                max = i;
            } else {
                if (max != min) {
                    Interval e = new Interval();
                    e.buy = min;
                    e.sell = max;
                    buySell.add(e);
                }
                max = i;
                min = i;
            }
        }

        if (price[min] <= price[max]) {
            Interval e = new Interval();
            e.buy = min;
            e.sell = max;
            buySell.add(e);
        }

        for (Interval e : buySell) {
            System.out.println("Buy on: " + e.buy + "    Sell on: " + e.sell);
        }
    }

    public void bestTimeStock(int[] p, int n) {
        List<List<Integer>> res = new ArrayList<>();
        int i = 0;
        while (i < n - 1) {
            while (i < n - 1 && p[i] >= p[i + 1]) {
                i++;
            }
            if (i == n - 1)
                break;
            int min = p[i];
            i++;
            while (i < n && p[i - 1] <= p[i]) {
                i++;
            }
            int max = p[i - 1];
            res.add(new ArrayList<>(Arrays.asList(min, max)));

        }
        for (List<Integer> l : res) {
            System.out.println(l.get(0) + ", " + l.get(1));
        }

    }

    public int bestTimeToBuyStockProfit(int price[], int n) {
        // Prices must be given for at least two days
        if (n == 1)
            return 0;

        int count = 0;

        // solution array
        ArrayList<Interval> sol = new ArrayList<Interval>();

        // Traverse through given price array
        int i = 0;
        while (i < n - 1) {
            // Find Local Minima. Note that the limit is (n-2) as we are
            // comparing present element to the next element.
            while ((i < n - 1) && (price[i + 1] <= price[i]))
                i++;

            // If we reached the end, break as no further solution possible
            if (i == n - 1)
                break;

            Interval e = new Interval();
            e.buy = i++;
            // Store the index of minima


            // Find Local Maxima.  Note that the limit is (n-1) as we are
            // comparing to previous element
            while ((i < n) && (price[i] >= price[i - 1]))
                i++;

            // Store the index of maxima
            e.sell = i - 1;
            sol.add(e);

            // Increment number of buy/sell
            count++;
        }

        // print solution
        if (count == 0)
            System.out.println("There is no day when buying the stock "
                    + "will make profit");
        else
            for (int j = 0; j < count; j++)
                System.out.println("Buy on day: " + sol.get(j).buy
                        + "        " + "Sell on day : " + sol.get(j).sell);

        return 0;
    }

    @Test
    public void findTwoSum() {
        int[] nums = new int[]{2, 7, 11, 15};
        // twoSum(nums, 9);
        threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }

    public void twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int comp = target - nums[i];
            if (map.containsKey(comp)) {
                System.out.print("[" + i + " , " + map.get(comp) + "]");
                return;
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public void threeSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int tar = nums[i] * -1;

            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                int comp = tar - nums[j];
                if (map.containsKey(comp)) {
                    System.out.print("[" + nums[i] + " , " + nums[j] + " , " + comp + "]");
                }
            }
        }
    }

    @Test
    public void longestPal() {
        String s = longestPalindromSubstring("abcdcbe");
        //longestPalSubstr("abcdcbe");
        System.out.print(s);
    }

    public String longestPalindromSubstring(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        int maxLength = 1;
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int start = 0;
        int end = 0;

        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        for (int k = 3; k <= len; k++) {
            for (int i = 0; i <= len - k; i++) {
                int j = k + i - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;

                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                        end = j;
                    }
                }

            }
        }
        return s.substring(start, end + 1);

    }

    @Test
    public void countIsland() {
        int mat[][] = {{1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}};

        int i = countIslandFunc(mat);
        System.out.print(i);

    }

    public int countIslandFunc(int[][] m) {
        boolean[][] visited = new boolean[m.length][m[0].length];
        int island = 0;

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    doCount(i, j, m, visited);
                    island = 1 + island;
                }
            }
        }
        return island;
    }

    private void doCount(int xx, int yy, int[][] m, boolean[][] visited) {
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        for (int i = 0; i < 8; i++) {
            int x = dx[i] + xx;
            int y = dy[i] + yy;

            if (safeValid(x, y, m, visited)) {
                visited[x][y] = true;
                doCount(x, y, m, visited);
            }
        }
    }

    @Test
    public void longest() {
        int[][] mat = new int[][]{
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                {1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
                {1, 0, 1, 1, 1, 1, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 0, 0, 0, 0, 1, 0, 0, 1}};

        Point source = new Point(0, 0);
        Point dest = new Point(3, 4);

        int i = shortestPath(mat, source, dest);
        System.out.print(i);
    }

    static class Point {
        public Point(int row, int col) {
            this.x = row;
            this.y = col;
        }

        int x;
        int y;
    }

    // An object to store data for queue used in BFS
    static class QueueNode {
        public QueueNode(Point src, int d) {
            this.pt = src;
            this.dist = d;
        }

        Point pt; // The coordinates of a cell
        int dist; // cell's distance of from the source
    }

    public int shortestPath(int[][] m, Point src, Point dest) {

        boolean[][] dp = new boolean[m.length][m[0].length];
        Queue<QueueNode> q = new LinkedList<>();

        if (m[dest.x][dest.y] == 0 || m[src.x][src.y] == 0) {
            return 0;
        }
        dp[src.x][src.y] = true;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        q.add(new QueueNode(src, 0));
        while (!q.isEmpty()) {
            QueueNode poll = q.poll();

            Point pt = poll.pt;

            if (pt.x == dest.x && pt.y == dest.y) {
                return poll.dist;
            }
            for (int i = 0; i < 4; i++) {
                int x = dx[i] + pt.x;
                int y = dy[i] + pt.y;
                if (safeValid(x, y, m, dp)) {
                    dp[x][y] = true;
                    q.add(new QueueNode(new Point(x, y), poll.dist + 1));

                }
            }
        }


        return 0;
    }


    private boolean safeValid(int x, int y, int[][] m, boolean[][] dp) {
        if (x >= 0 && y >= 0 && x < m.length && y < m[0].length && m[x][y] == 1 && !dp[x][y]) {
            return true;
        }
        return false;
    }

    @Test
    public void letterCombAlp() {
        int[] n = {1, 2};
        List<String> strings = letterCombinations(n);


        for (int i = 0; i < strings.size(); i++) {
            System.out.print(strings.get(i) + " ");
        }
    }

    static List<String> letterCombinations(int[] num) {
        // table[i] stores all characters that
        // corresponds to ith digit in phone
        String[] table = {"", "", "abc", "def", "ghi", "jkl",
                "mno", "pqrs", "tuv", "wxyz"};

        List<String> list = new ArrayList<>();
        int n = num.length;

        Queue<String> q = new LinkedList<>();

        q.add("");

        while (!q.isEmpty()) {
            String poll = q.poll();

            if (poll.length() == num.length) {
                list.add(poll);
            } else {
                String alp = table[num[poll.length()]];
                for (int i = 0; i < alp.length(); i++) {
                    q.add(poll + alp.charAt(i));
                }
            }
        }
        return list;
    }

    public void dfs(List<String> rst, List<String> list, char[] digit, int level) {
        if (list.size() == digit.length) {
            StringBuffer sb = new StringBuffer();
            for (String str : list) {
                sb.append(str);
            }
            rst.add(sb.toString());
            return;
        }

        List<String> letters = map.get(digit[level]);
        for (String letter : letters) {
            list.add(letter);
            dfs(rst, list, digit, level + 1);
            list.remove(list.size() - 1);
        }
    }

    final Map<Character, List<String>> map = new HashMap<>();

    @Test
    public void letterCombinations() {
        final List<String> rst = new ArrayList<String>();
        String digits = "23";

        //Prepare map
        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        map.put('4', Arrays.asList("g", "h", "i"));
        map.put('5', Arrays.asList("j", "k", "l"));
        map.put('6', Arrays.asList("m", "n", "o"));
        map.put('7', Arrays.asList("p", "q", "r", "s"));
        map.put('8', Arrays.asList("t", "u", "v"));
        map.put('9', Arrays.asList("w", "x", "y", "z"));

        List<String> list = new ArrayList<>();
        dfs(rst, list, digits.toCharArray(), 0);

        for (int i = 0; i < rst.size(); i++) {
            System.out.print(rst.get(i) + " ");
        }
    }

    @Test
    public void validpar() {
        boolean valid = isValid("((d))");
        System.out.print(valid);
    }

    public boolean isValid(String s) {

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();


        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (stack.empty() || stack.pop() != map.get(c)) {
                    return false;
                }
            } else
                stack.push(c);
        }

        return stack.isEmpty();
    }

    public class Graph {
        private int V;   // No. of vertices
        private List<List<Integer>> adj; // Adjacency List Represntation

        // Constructor
        public Graph(int v) {
            this.V = v;
            this.adj = new ArrayList<>(V);
            for (int i = 0; i < V; ++i)
                adj.add(new LinkedList<>());
        }

        // Function to add an edge into the graph
        void addEdge(int v, int w) {
            adj.get(v).add(w);
            adj.get(w).add(v);
        }
    }

    @Test
    public void isUnGraphCyclic() {
        Graph g = new Graph(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 0);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        boolean cyclic = isCyclic(g);
        Assert.isTrue(cyclic);
    }

    private boolean isCyclic(Graph g) {
        boolean[] visited = new boolean[g.V];

        for (int i = 0; i < g.V; i++) {
            if (isCyclicUtil(g, i, visited, -1)) {
                return true;
            }
            ;
        }
        return false;

    }

    private boolean isCyclicUtil(Graph g, int i, boolean[] visited, int parent) {
        if (visited[i]) {
            return false;
        }

        visited[i] = true;

        List<Integer> integers = g.adj.get(i);

        Iterator<Integer> iterator = integers.iterator();

        while (iterator.hasNext()) {
            Integer next = iterator.next();

            if (!visited[next]) {
                if (isCyclicUtil(g, next, visited, i)) {
                    return true;
                }
                ;
            } else if (parent != next) {
                return true;
            }

        }

        return false;


    }

    @Test
    public void wordBreak() {
        // List of Strings to represent dictionary
        List<String> dict = Arrays.asList("this", "th", "is", "famous",
                "Word", "break", "b", "r", "e", "a", "k",
                "br", "bre", "brea", "ak", "problem");

        // input String
        String str = "Wordbreakproblem";

        if (realWordBreak(dict, str)) {
            System.out.print("String can be segmented");
        } else {
            System.out.print("String can't be segmented");
        }

        wordBreak(dict, str, "");
    }

    public void wordBreak(List<String> dict, String str, String out) {
        if (str.length() == 0) {
            System.out.println(out);
            return;
        }

        for (int i = 1; i <= str.length(); i++) {
            String prefix = str.substring(0, i);

            if (dict.contains(prefix)) {
                wordBreak(dict, str.substring(i), out + " " + prefix);
            }

        }
    }

    public static boolean realWordBreak(List<String> dict, String str) {
        // return true if we have reached the end of the String,
        if (str.length() == 0) {
            return true;
        }

        for (int i = 1; i <= str.length(); i++) {
            // consider all prefixes of current String
            String prefix = str.substring(0, i);

            // return true if prefix is present in the dictionary and
            // remaining string also forms space-separated sequence of
            // one or more dictionary words

            if (dict.contains(prefix) && realWordBreak(dict, str.substring(i))) {
                return true;
            }
        }

        // return false if the String can't be segmented
        return false;
    }

    @Test
    public void subset() {
        List<List<Integer>> subsets = subsets(new int[]{5, 6, 7});

        for (List<Integer> list : subsets) {
            for (Integer i : list) {
                System.out.print(i);
            }
        }
    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;

    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public class Node {
        Node left;
        Node right;
        int val;

        public Node(int n) {
            this.val = n;
        }
    }

    public boolean isBinarySearchTree(Node n) {
        return isBinarySearchUtil(n, Integer.MAX_VALUE, Integer.MAX_VALUE);

    }


    private boolean isBinarySearchUtil(Node n, int minValue, int maxValue) {
        if (n == null) {
            return true;
        }

        if (n.val > maxValue || n.val < minValue) {
            return false;
        }

        return isBinarySearchUtil(n.left, minValue, n.val - 1) &&
                isBinarySearchUtil(n.right, n.val + 1, maxValue);

    }

    public int knap(int[] wt, int[] val, int W, int n) {
        if (W == 0 || n == 0) {
            return 0;
        }

        if (wt[n - 1] > W) {
            return knap(wt, val, W, n - 1);
        }

        return Math.max(knap(wt, val, W, n - 1), knap(wt, val, W - wt[n - 1], n - 1) + val[n - 1]);

    }

    public int knapDP(int[] wt, int[] val, int W, int n) {

        int dp[][] = new int[n + 1][W + 1];

        // Build table K[][] in bottom up manner
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (wt[i - 1] > w)
                    dp[i][w] = dp[i - 1][w];
                else
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);

            }
        }

        return dp[n][W];

    }

    @Test
    public void knapsack() {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int W = 50;
        int n = val.length;
        System.out.println(knapDP(wt, val, W, n));
        System.out.println(knap(wt, val, W, n));
        System.out.println(knapAgain(wt, val, W, n));
    }

    class Elem {
        public int value;
        public int min;
        public Elem next;

        public Elem(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }

    class MinStack {

        /**
         * initialize your data structure here.
         */
        public MinStack() {
        }

        Elem start;

        public void push(int x) {
            if (start == null) {
                start = new Elem(x, x);
            }

            Elem top = new Elem(x, Math.min(x, start.min));
            top.next = start;
            start = top;

        }

        public void pop() {
            if (start == null)
                return;
            Elem temp = start.next;
            start.next = null;
            start = temp;

        }

        public int top() {
            if (start == null)
                return -1;
            return start.value;

        }

        public int getMin() {
            if (start == null)
                return -1;
            return start.min;
        }
    }

    public class NodeLevel {
        Node n;
        int level;

        public NodeLevel(Node n, int level) {
            this.n = n;
            this.level = level;
        }
    }

    @Test
    public void printRightTree() {
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        tree.right.left = new Node(6);
        tree.right.right = new Node(7);
        tree.right.left.right = new Node(8);
        printright(tree);
    }

    public void printright(Node n) {
        Queue<NodeLevel> q = new LinkedList<>();
        q.add(new NodeLevel(n, 0));
        while (!q.isEmpty()) {
            NodeLevel poll = q.poll();
            if (poll.n.left != null) {
                q.add(new NodeLevel(poll.n.left, poll.level + 1));
            }

            if (poll.n.right != null) {
                q.add(new NodeLevel(poll.n.right, poll.level + 1));
            }

            NodeLevel peek = q.peek();
            if (peek == null || peek.level != poll.level) {
                System.out.print(poll.n.val);
            }
        }
    }

    @Test
    public void boogle() {
        String dictionary[] = {"GEEKS", "FOR", "QUIZ", "GUQ", "EE"};
        char boggle[][] = {{'G', 'I', 'Z'},
                {'U', 'E', 'K'},
                {'Q', 'S', 'E'}};

        doBoogle(boggle, dictionary);


    }

    private void doBoogle(char[][] boggle, String[] dictionary) {

        for (int i = 0; i < boggle.length; i++) {
            for (int j = 0; j < boggle[0].length; j++) {
                boolean[][] visited = new boolean[boggle.length][boggle[0].length];
                doBoogleUtil(i, j, boggle, visited, "", dictionary);
            }
        }

    }

    private void doBoogleUtil(int i, int j, char[][] boggle, boolean[][] visited, String str, String[] dictionary) {
        visited[i][j] = true;
        String newStr = str + boggle[i][j];
        if (isWord(newStr, dictionary)) {
            System.out.println(newStr);
        }
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int k = 0; k < 8; k++) {
            int x = dx[k] + i;
            int y = dy[k] + j;

            if (isSafe(x, y, boggle, visited)) {
                doBoogleUtil(x, y, boggle, visited, newStr, dictionary);
            }
        }

        //  str = "" + str.charAt(str.length() - 1);
        visited[i][j] = false;

    }

    private boolean isSafe(int i, int j, char[][] boggle, boolean[][] visited) {
        return (i >= 0 && j >= 0 && i < boggle.length && j < boggle[0].length && !visited[i][j]);

    }

    static boolean isWord(String str, String[] dictionary) {
        // Linearly search all words
        for (int i = 0; i < dictionary.length; i++)
            if (str.equals(dictionary[i]))
                return true;
        return false;
    }

    @Test
    public void cuttingRod() {
        int arr[] = new int[]{1, 5, 8, 9};
        int size = 4;
        System.out.println("Maximum Obtainable Value is " +
                cutRod(arr, size));
    }

    private int cutRod(int[] val, int size) {

        int[] dp = new int[size + 1];
        dp[0] = 0;
        for (int i = 1; i <= size; i++) {
            int res = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {

                res = Math.max(res, val[j] + dp[i - j - 1]);
            }
            dp[i] = res;
        }
        return dp[val.length];
    }

    @Test
    public void slidingWindowMax() {
        int num[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 3;
        int[] ints = doSlidingWindowMax(num, k);

        for (int i : ints) {
            System.out.println(i);
        }

    }

    private int[] doSlidingWindowMax(int[] num, int k) {
        int max = 0;
        int[] res = new int[num.length - k + 1];
        for (int i = 0; i <= num.length - k; i++) {
            for (int j = 0; j < k; j++) {
                max = Math.max(max, num[i + j]);
            }
            res[i] = max;
        }


        return res;

    }

    @Test
    public void minKthElement() {
        int arr[] = {12, 3, 5, 7, 19};
        int i = doPriorityQue(arr, 2);
        System.out.print(i);
        int j = findKthLargest(arr, 2);
        System.out.print(j);
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
        for (int i : nums) {
            q.offer(i);

            if (q.size() > k) {
                q.poll();
            }
        }

        return q.peek();
    }

    private int doPriorityQue(int[] num, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(k, Collections.reverseOrder());
        for (int i = 0; i < num.length; i++) {
            q.add(num[i]);

            if (q.size() > k) {
                q.poll();
            }


        }
        return q.peek();

    }

    @Test
    public void kClosestElement() {
        int arr[] = {12, 16, 22, 30, 35, 39, 42,
                45, 48, 50, 53, 55, 56};
        findKthLargestAgain(arr, 35, 4);
    }

    private void findKthLargestAgain(int[] arr, int k, int x) {

        int mid = findPivot(arr, 0, arr.length, x);
        int low = mid;

        if (arr[mid] == k) {
            low = mid - 1;
        }
        int high = mid + 1;
        int res = 0;
        List<Integer> result = new ArrayList<>();
        while (res <= k && high < arr.length && low >= 0) {

            if (arr[high] - k < k - arr[low]) {
                result.add(arr[high]);
                high--;
            } else {
                result.add(arr[low]);
                low++;
            }
            res++;
        }

        if (res <= k && low >= 0) {
            result.add(arr[low]);
            low--;
            res++;
        }

        if (res <= k && high < arr.length) {
            result.add(arr[high]);
            high++;
            res++;
        }
    }

    private int findPivot(int[] arr, int l, int h, int x) {


        if (arr[l] >= x) {
            return l;
        }
        if (arr[h] <= x) {
            return h;
        }
        int mid = (l + h / 2) + l;

        if (arr[mid] <= x && arr[mid + 1] > x) {
            return mid;
        }

        if (x < arr[mid]) {
            return findPivot(arr, l, mid - 1, x);
        } else {
            return findPivot(arr, mid + 1, h, x);
        }

    }

    @Test
    public void LCSubsequence() {
        String a = "ABCBDAB";
        String b = "BDCABA";
        System.out.print(longest(a, b));
    }

    private int longest(String a, String b) {

        if (a.length() == 0 || b.length() == 0) {
            return 0;
        }

        if (a.charAt(a.length() - 1) == b.charAt(b.length() - 1)) {
            return longest(a.substring(0, a.length() - 1), b.substring(0, b.length() - 1)) + 1;
        } else {
            return Math.max(longest(a.substring(0, a.length() - 1), b), longest(a, b.substring(0, b.length() - 1)));
        }


    }

    @Test
    public void amazonLocker() {
        int[][] m = new int[][]{{0, 0, 0, 1},
                {0, 0, 1, 1},
                {0, 1, 1, 0}};
        int[][] ints = doAmazonLocker(m);

        for (int[] row : ints)

            // converting each row as string
            // and then printing in a separate line
            System.out.println(Arrays.toString(row));

    }

    private int[][] doAmazonLocker(int[][] m) {
        int[][] dp = new int[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] == 0) {
                    dp[i][j] = doBFS(i, j, m, dp);
                }
            }
        }
        return dp;


    }

    class QueNode {
        private Point p;
        private int c;

        public QueNode(Point point, int i) {
            this.p = point;
            this.c = i;
        }
    }

    private int doBFS(int i, int j, int[][] m, int[][] dp) {
        Queue<QueNode> q = new LinkedList<>();
        boolean[][] visited = new boolean[m.length][m[0].length];
        q.add(new QueNode(new Point(i, j), 0));
        visited[i][j] = true;
        while (!q.isEmpty()) {

            QueNode poll = q.poll();
            Point point = poll.p;
            int count = poll.c;
            if (m[point.x][point.y] == 1) {
                return count;
            }


            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, 1, 0, -1};

            for (int k = 0; k < 4; k++) {
                int x = dx[k] + point.x;
                int y = dy[k] + point.y;

                if (x >= 0 && y >= 0 && x < m.length && y < m[0].length && !visited[x][y]) {
                    q.add(new QueNode(new Point(x, y), count + 1));
                    visited[x][y] = true;
                }

            }
        }
        return 0;
    }

    public class Graph2 {
        private int v;
        private List<List<Integer>> adj;

        public Graph2(int v) {
            this.v = v;
            this.adj = new ArrayList<>();

            for (int i = 0; i < v; i++) {
                adj.add(new LinkedList<>());
            }
        }

        void addEdge(int v, int w) {
            adj.get(v).add(w);
        }
    }

    @Test
    public void task() {
        Graph2 g = new Graph2(4);
        g.addEdge(1, 0);
        g.addEdge(2, 1);
        g.addEdge(3, 2);
        boolean b = doIsCycle(g);
        System.out.println(b);
    }

    private boolean doIsCycle(Graph2 g) {
        boolean[] rec = new boolean[g.v];
        boolean[] visited = new boolean[g.v];
        for (int i = 0; i < g.v; i++) {
            if (isCycleUtl(g, i, visited, rec)) {
                return true;
            }
            ;
        }
        return false;
    }

    private boolean isCycleUtl(Graph2 g, int i, boolean[] visited, boolean[] rec) {
        if (rec[i]) {
            return true;
        }

        if (visited[i]) {
            return false;
        }

        rec[i] = true;
        visited[i] = true;

        List<Integer> integers = g.adj.get(i);
        Iterator<Integer> iterator = integers.iterator();

        while (iterator.hasNext()) {
            Integer next = iterator.next();

            if (isCycleUtl(g, next, visited, rec)) {
                return true;
            }
        }
        rec[i] = false;
        return false;
    }


    @Test
    public void topological() {
        Graph2 g = new Graph2(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        topo(g);
    }

    private void topo(Graph2 g) {

        Stack<Integer> s = new Stack<>();
        boolean[] visited = new boolean[g.v];
        for (int i = 0; i < g.v; i++) {
            if (!visited[i]) {
                doTopological(g, i, visited, s);
            }
        }

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    private void doTopological(Graph2 g, int i, boolean[] visited, Stack<Integer> s) {
        visited[i] = true;

        List<Integer> integers = g.adj.get(i);
        Iterator<Integer> iterator = integers.iterator();

        while (iterator.hasNext()) {
            Integer next = iterator.next();

            if (!visited[next]) {
                doTopological(g, next, visited, s);
            }
        }
        s.push(i);

    }

    @Test
    public void Test() {
        String[] words = {"baa", "abcd", "abca", "cab", "cad"};
        doAlien(words, 4);
    }

    private void doAlien(String[] words, int alpha) {
        Graph2 g = new Graph2(alpha);

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            for (int j = 0; j < word1.length() && j < word2.length(); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    g.addEdge(word1.charAt(j) - 'a', word2.charAt(j) - 'a');
                    break;
                }
            }

        }

        Stack<Integer> s = new Stack<>();
        boolean[] visited = new boolean[alpha];

        for (int i = 0; i < g.v; i++) {
            if (!visited[i]) {
                doAlienTopo(g, i, visited, s);
            }
        }


        while (!s.isEmpty()) {
            System.out.print((char) ('a' + s.pop()) + " ");
        }
    }

    private void doAlienTopo(Graph2 g, int i, boolean[] visited, Stack<Integer> s) {
        visited[i] = true;

        Iterator<Integer> iterator = g.adj.get(i).iterator();

        while (iterator.hasNext()) {
            Integer next = iterator.next();

            if (!visited[next]) {
                doAlienTopo(g, next, visited, s);
            }
        }
        s.push(i);

    }

    @Test
    public void searchMatrix() {
        int mat[][] = {{10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}};

        searchM(mat, 32);
    }

    private void searchM(int[][] m, int k) {

        int i = 0;
        int j = m.length - 1;

        while (i < m.length && j >= 0) {

            if (m[i][j] == k) {
                System.out.println("found at x: " + i + "y: " + j);
                return;
            } else if (m[i][j] > k) {
                j--;
            } else if (m[i][j] < k) {
                i++;
            }

        }
        System.out.println("NOT FOUND");

    }

    @Test
    public void LCS() {
        String X = "XMJYAUZ", Y = "MZJAWXU";
        System.out.println(longestCommonSubsequence(X, Y));

    }

    private int longestCommonSubsequence(String x, String y) {
        int[][] dp = new int[x.length() + 1][y.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[x.length()][y.length()];
    }

    public int knapAgain(int[] wt, int[] val, int W, int n) {
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;

                } else if (wt[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][W-wt[i-1]], dp[i - 1][j]);
            }
        }

        return dp[n][W];

    }

    @Test
    public void findLargestSquare() {
        int[][] M =
                {
                        {0, 0, 1, 0, 1, 1},
                        {0, 1, 1, 1, 0, 0},
                        {0, 0, 1, 1, 1, 1},
                        {1, 1, 0, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1},
                        {1, 1, 0, 1, 1, 1},
                        {1, 0, 1, 1, 1, 1},
                        {1, 1, 1, 0, 1, 1}
                };
        System.out.print(findLargestSquare(M));
    }

    private int findLargestSquare(int[][] m) {

        int[][] dp = new int[m.length + 1][m[0].length + 1];
        int res = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (m[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    res = Math.max(dp[i][j], res);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return res;

    }

    @Test
    public void quickSort() {
        int[] n = {4, 5, 1, 2, 3, 3};

        quickS(n, 0, n.length - 1);
        System.out.println(Arrays.toString(n));
    }

    private void quickS(int[] n, int start, int last) {

        int pivot = parition(n, start, last);
        if (pivot + 1 < last) {
            quickS(n, pivot + 1, last);
        }
        if (pivot - 1 > start) {
            quickS(n, start, pivot - 1);
        }


    }

    private int parition(int[] n, int start, int last) {
        int pivot = n[last];

        for (int i = start; i < last; i++) {
            if (n[i] < pivot) {
                int temp = n[start];
                n[start] = n[i];
                n[i] = temp;
                start++;
            }
        }

        int temp = n[start];
        n[start] = pivot;
        n[last] = temp;

        return start;

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @Test
    public void strToBinary() {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.left = new TreeNode(4);
        doPreOrderTraversal(t);
    }

    private void doPreOrderTraversal(TreeNode t) {
        if (t == null) {
            return;
        }

        System.out.print(t.val);

        if (t.left != null) {
            System.out.print("(");
            doPreOrderTraversal(t.left);
            System.out.print( ")");
        }


        if (t.right != null) {
            System.out.print("(");
            doPreOrderTraversal(t.right);
            System.out.print( ")");
        }

    }

    @Test
    public void kDiffPairs() {
        int[] num = new int[] {0,0,1,1,2,2,3,4,5};
        int k = 0;
        doKDiff(num, k);
    }

    private void doKDiff(int[] num, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < num.length; i++) {
            if (map.containsKey(num[i])) {
                List<Integer> integer = map.get(num[i]);
                integer.add(i);
                map.put(num[i], integer);
            } else {
                map.put(num[i], new ArrayList<>(Arrays.asList(i)));
            }
        }

        if (k == 0) {
            Collection<List<Integer>> values = map.values();
            for (List<Integer> l : values) {
                if (l.size() % 2 == 0) {
                    System.out.println(l.toArray());
                }
            }
        }

        for (int i = 0; i < num.length; i++) {


            int temp = k + num[i];

            if (map.containsKey(temp)) {
                System.out.println(num[i] + " " + temp);
            }
        }
    }

    @Test
    public void longestSubPal() {
        String str ="forgeeksskeegfor";
        System.out.println(doLongestSub(str));


        String s = "babcbab";
        System.out.println(doLongestSeq(s));
    }

    private int doLongestSub(String str) {

        boolean[][] dp = new boolean[str.length()][str.length()];
        int res = 0;
        for (int i = 0 ; i < str.length(); i++) {
            dp[i][i] = true;
            res = 1;
        }

        for (int i = 0; i < str.length() -1 ;i++) {
            if (str.charAt(i) == str.charAt(i+1)) {
                dp[i][i+1] = true;
                res = 2;
            }
        }

        for (int i = 3; i <= str.length(); i++) {

            for (int j = 0; j < str.length() - i; j++) {
                if (str.charAt(j) == str.charAt(j+i-1)) {
                    if (dp[j+1][j+i-1-1]) {
                        dp[j][j+i-1] = true;
                        res = i;
                    }
                }
            }

        }
        return res;
    }


    private int doLongestSeq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        int res = 0;
        for (int i = 0 ; i < s.length(); i++) {
            dp[i][i] = 1;
            res = 1;
        }

        for (int i = 0; i <= s.length()-2 ;i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = dp[i+1][i] +2;
            } else {
                dp[i][i+1] = Math.max(dp[i+1][i+1], dp[i][i+1-1]);
            }
        }

        for (int i = 3; i <= s.length(); i++) {

            for (int j = 0; j <= s.length()-i ; j++) {

                if (s.charAt(j) == s.charAt(j+i-1)) {
                    dp[j][j+i-1] = dp[j+1][j+i-1-1] + 2;
                } else {
                    dp[j][j+i-1] = Math.max(dp[j+1][j+i-1], dp[j][j+i-1-1]);
                }
                res = Math.max(res, dp[j][j+i-1]);


            }
        }
        return res;
    }

    @Test
    public void df() {
        print(100);
    }


    public void print(int n) {

        for (int i = 1; i <= n; i++) {


            if (i % 3 == 0 && i % 5 == 0) {
                System.out.print("DevOps");
            } else if (i % 3 == 0) {
                System.out.print("Dev");
            } else if (i % 5 == 0) {
                System.out.print("Ops");
            } else {
                System.out.print(i);
            }

        }
    }
    @Test
    public void split() {

    }


    public int split (int [] num) {
        int i = 0;
        int j = num.length-1;

        if (num.length <= 1) {
            return -1;
        }

        int is = num[0];
        int js = num[j];

        j++;
        i++;
        while (i <= j) {

            if (is < js) {
                is = is + num[i];
                i++;
            } else if(js < is) {
                js = js + num[j];
                j--;
            } else {
                is = is + num[i];
                js = js + num[j];
                i++;
                j--;
            }
        }
        for (int k = 0; k < i; i++) {
            System.out.print(num[i]);
        }

        for (int l = j+1; l < num.length; l++) {
            System.out.print(num[l]);
        }
        return 0;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0 , strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        }
        else {
            int mid = (r-l)/2 + l ;
            String lcpLeft =   longestCommonPrefix(strs, l , mid);
            String lcpRight =  longestCommonPrefix(strs, mid + 1,r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    String commonPrefix(String left,String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if ( left.charAt(i) != right.charAt(i) )
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }

    @Test
    public void doLongCommonPrefix() {
        String[] x = new String[]{"leets", "leetcode", "leet", "leed"};
        String s = longestCommonPrefix(x);
        System.out.println(s);

        int[] n = new int[] {1,1,2,3,4,5};
        System.out.println(removeDuplicates(n));
    }



    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    @Test
    public void rotate() {
        int[] p = new int[] {1,2,3,4,5,6,7};
    int k = 3;
        rotate(p, k);
    }


    public void rotate(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    public static List<String> getTopCompetitors(int topNCompetitors
            , String[] competitors, String[] reviews) {
        HashMap<String, Integer> map = new HashMap<>();
        // add all competitors into HashMap
        for (int i = 0; i < competitors.length; i++) {
            map.put(competitors[i].toLowerCase(), 0);
        }

        // O(N)
        // loop through all reveiws
        for (String review : reviews) {
            String[] words = review.toLowerCase().split(" ");

            Set<String> used = new HashSet<>();
            // loop through all words in a review
            for (String word : words) {
                if (map.containsKey(word)
                        && used.add(word)) {
                    map.put(word, map.get(word) + 1);
                }
            }
        }

        // O(log N)
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((a, b) -> (a.getValue() == b.getValue()
                ? b.getKey().compareTo(a.getKey())
                : a.getValue() - b.getValue()));

        // O(N)
        for (Map.Entry entry : map.entrySet()) {
            queue.offer(entry);
            if (queue.size() > topNCompetitors) {
                queue.poll();
            }
        }

        // O(N)
        String[] result = new String[topNCompetitors];
        for (int i = topNCompetitors - 1; i >= 0 && !queue.isEmpty(); i--) {
            Map.Entry<String, Integer> entry = queue.poll();
            result[i] = entry.getKey();
        }

        ArrayList<String> r = new ArrayList<>();
        for (String d : result) {
            r.add(d);
        }
        return r;
    }

    @Test
    public void atoi() {
        String x = "42";
        char[] chars = x.toCharArray();

        int i = '0' - '0';
        System.out.print(i);
    }


    @Test
    public void passby() {
        String x = "pop";
        List<String> rest = new ArrayList<>(Arrays.asList(x));
        int i = 3;
        int[] intlist = new int[] {1,2,3,4,5};
        System.out.println(Arrays.toString(intlist));
        Integer j = 7;
        pass(x,i,rest, j,intlist);
        System.out.println(j);
        System.out.println(i);
        System.out.println(x);
        System.out.println(rest);
        System.out.println(Arrays.toString(intlist));

    }

    private void pass(String x, int i, List<String> rest, Integer j, int[] intlist) {
        x = "nesd";
        i = 4;
        j = 4;
        rest.add("dsfsdf");
        for (int k = 0; k < intlist.length; k++) {
            intlist[k] = k;
        }
    }

    @Test
    public void falssee() {
        int[] row = new int[] {2,4,2,4};
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
        System.out.println(row);

        int[] res = new int[4];
        int count = 0;
        // add number to the left;
        for (int i = 0 ; i < row.length; i++) {
            if (row[i] != 0) {
                res[count] = row[i];
                count++;
            }
        }

        // add rest of zeros
        for (int i = count; i < 4; i++) {
            res[count] = 0;
        }

        System.out.println(row);

    }



}