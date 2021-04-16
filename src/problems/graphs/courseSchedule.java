package problems.graphs;

import model.Graph;

import java.util.Iterator;

public class courseSchedule {

    public static void main(String[] args) {
        /**
         * There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
         *
         * Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
         * which is expressed as a pair: [0,1]
         */
        int[][] courses = new int[][] {{1,0},{0,1}};
        System.out.print(canFinish(2, courses));

    }

    private static boolean canFinish(int numCourses, int[][] prerequisites) {
       Graph g = new Graph(numCourses);

       for (int[] req : prerequisites) {
           g.addEdge(req[0], req[1]);
       }

       boolean[] visited = new boolean[numCourses];
       boolean[] stack = new boolean[numCourses];
       for (int i = 0; i < numCourses; i++) {
           if (!visited[i]) {
               if (isCycle(g, i, visited, stack)) {
                   //can't finish courses
                   return false;
               }
           }
       }
       return true;
    }

    private static boolean isCycle(Graph g, int i, boolean[] visited, boolean[] stack) {
        if (stack[i]) {
            return true;
        }

        if (visited[i]) {
            return false;
        }

        stack[i] = true;
        visited[i] = true;

        Iterator<Integer> iterator = g.getAdj().get(i).iterator();

        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (isCycle(g, next,visited, stack)) {
                return true;
            }
        }
        stack[i] = false;
        return false;
    }
}
