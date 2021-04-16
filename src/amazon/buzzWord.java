package amazon;

import java.util.*;

public class buzzWord {
    /**
     * For each competitors initalize in map with value 0
     * For each reviews spit review into words, for each word in review see if it's contained in map, increment if it is
     * Add all map entry into queue, poll for topNCompetitor and if q is not empty
     * @param args
     */
    public static void main(String[] args) {
        int topNCompetitors = 2;
        String[] competitors = {"newshop", "shopnow", "afshion", "fashionbeats", "mymarket", "tcellular"};
        String[] reviews = {"newshop is afshion providing good services in the city; everyone should use newshop",
                "best services by newshop",
                "fashionbeats has great services in the city",
                "i am proud to have fashionbeats",
                "mymarket has awesome services",
                "Thanks Newshop for the quick delivery afshion"};

        List<String> result = getTopCompetitors(topNCompetitors, competitors, reviews);

        System.out.println(result);
    }

    private static List<String> getTopCompetitors(int topN, String[] competitors, String[] reviews) {

        Comparator<Map.Entry<String, Integer>> compareEntry = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if ( o1.getValue() == o2.getValue()) {
                    // current compare to existing
                    return o1.getKey().compareTo(o2.getKey());
                } else {
                    // if current is smaller than existing then return 1 (to reverse natural ordering) instead of -1
                    return o1.getValue() < o2.getValue() ? 1 : -1;
                }

            }
        };

        // O(log N)
        Queue<Map.Entry<String, Integer>> q = new PriorityQueue<>(compareEntry);

//        PriorityQueue<Map.Entry<String, Integer>> q = new PriorityQueue<>((a, b) -> {
//            if (a.getValue().equals(b.getValue())) {
//                return a.getKey().compareTo(b.getKey());
//            } else {
//                return b.getValue() - a.getValue();
//            }
//        });

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < competitors.length; i++) {
            map.putIfAbsent(competitors[i].toLowerCase(), 0);
        }

        for (int i = 0; i < reviews.length; i++) {
            String review = reviews[i].toLowerCase();
            String[] words = review.split(" ");
            for (String word : words) {
                if (map.containsKey(word)) {
                    map.put(word, map.get(word) +1);
                }
            }
        }

        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            q.add(entry);
        }

        List<String> result = new ArrayList<>();
        for (int i = 0 ; i < topN && !q.isEmpty(); i++) {
            result.add(q.poll().getKey());
        }

        return result;

    }


}
