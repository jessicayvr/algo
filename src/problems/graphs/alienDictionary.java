package problems.graphs;

import java.util.*;

public class alienDictionary {

    public static void main(String[] args) {
        String[] words = {"baa", "abcd", "abca", "cab", "cad"};
        System.out.print(doAlien(words));
    }

    private static List<Character> doAlien(String[] words) {
        AlienGraph graph = new AlienGraph();

        for (int i = 0; i < words.length - 1; i++) {
            // compare words at i and i+1
            for (int j = 0; j < Math.min(words[i].length(), words[i+1].length()); j++) {

                // if character is different add edge and break
                if (words[i].charAt(j) != words[i+1].charAt(j)) {
                    graph.addEdge(words[i].charAt(j), words[i+1].charAt(j));
                    break;
                }
            }
        }

        return graph.doTopologicalSort();
    }

    public static class AlienGraph{
        Map<Character, List<Character>> adjMap;

        public AlienGraph() {
            adjMap = new HashMap<>();
        }

        public void addEdge(Character x, Character y) {
            List<Character> adj = adjMap.getOrDefault(x, new ArrayList<>());
            adj.add(y);
            adjMap.put(x, adj);
            adjMap.putIfAbsent(y, new ArrayList<>());
        }

        public List<Character> doTopologicalSort() {
            Set<Character> characters = adjMap.keySet();
            Set<Character> visited = new HashSet<>();
            Stack<Character> stack = new Stack<>();
            for (Character c: characters) {
                if (!visited.contains(c)) {
                    doTopologicalUtil(c, visited, stack);
                }
            }
            List<Character> result = new ArrayList<>();
            while(!stack.isEmpty()) {
                result.add(stack.pop());
            }
            return result;
        }

        private void doTopologicalUtil(Character c, Set<Character> visited, Stack<Character> stack) {
            visited.add(c);

            Iterator<Character> iterator = adjMap.get(c).iterator();

            while (iterator.hasNext()) {
                Character next = iterator.next();
                if (!visited.contains(next)) {
                    doTopologicalUtil(next, visited, stack);
                }
            }

            stack.add(c);
        }
    }
}
