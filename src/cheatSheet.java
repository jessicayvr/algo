import java.util.*;

public class cheatSheet {

    public static void main(String[] args) {
        convertListToString();
    }

    // List<List<Integer>> to int[][]
    public void converListListToMatrix() {
        List<List<Integer>> grid = new ArrayList<>();

        int[][] newGrid = grid.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }
    // List<Integer> to int[]
    public void ListIntegerToList() {
        List<Integer> result = new ArrayList<>();
        result.stream().mapToInt(i->i).toArray();
    }

    public void convertListListToListArray() {
        List<List<Integer>> merged = new ArrayList<>();

        merged.toArray(new int[merged.size()][]);
    }

    // List<String> -> String[]
    public static void convertStringToList() {
        List<String> strings =
                new ArrayList<String>(Arrays.asList(new String[]{"one", "two", "three"}));
    }

    public static void convertListToString() {
        List<String> result = new ArrayList<>(Arrays.asList("abc", "cde"));

        // Same
        String[] strings = result.stream().toArray(String[]::new);
        String[] strings1 = result.toArray(new String[0]);
    }

    /**
     * String is in natural order, Value is in DESCENDING ORDER
     */
    public static void compareIntergersAndString() {
        Comparator<Map.Entry<String, Integer>> comparePoints = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> current, Map.Entry<String, Integer> existing) {
                if (current.getValue() == existing.getValue()) {
                    return current.getKey().compareTo(existing.getKey());
                } else {
                    return existing.getValue() < current.getValue() ? -1 : 1;
                }

            }
        };
        Queue<Map.Entry<String, Integer>> q = new PriorityQueue<>(comparePoints);

        /*
         * SAME AS ABOVE
         */
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((a, b) -> {
            if (a.getValue().equals(b.getValue())) {
                return a.getKey().compareTo(b.getKey());
            } else {
                return b.getValue() - a.getValue();
            }
        });
    }

    public static void compareExamplesIntegersNaturalOrder() {

        Comparator<int[]> comparePoints = new Comparator<int[]>() {
            @Override
            public int compare(int[] current, int[] existing) {
                int sqrtCurrent = (current[0] * current[0]) + (current[1] * current[1]);
                int sqrtExisting = (existing[0] * existing[0]) + (existing[1] * existing[1]);

                if (Math.sqrt(sqrtCurrent) < Math.sqrt(sqrtExisting)) {
                    return -1;
                } else {
                    return 1;
                }
            }
        };

        PriorityQueue<int[]> q = new PriorityQueue<>(comparePoints);

        // same as
        Queue<int[]> que = new PriorityQueue<>((current, existing) -> {
            int sqrtCurrent = (current[0] * current[0]) + (current[1] * current[1]);
            int sqrtExisting = (existing[0] * existing[0]) + (existing[1] * existing[1]);

            if (Math.sqrt(sqrtCurrent) < Math.sqrt(sqrtExisting)) {
                return -1;
            } else {
                return 1;
            }
        });

    }
}
