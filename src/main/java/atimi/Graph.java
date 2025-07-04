package atimi;

import java.util.*;

public class Graph {
    /**
     * Neighbour nodes graph, e.g A-B-C-D
     * A: B
     * B: A,C
     * C: B.D
     * D: C
     */
    private final Map<Character, List<Character>> graph = Map.of('A', List.of('B'),
            'B', List.of('A', 'C'),
            'C', List.of('B', 'D'),
            'D', List.of('C'));

    private final Set<Character> visited = new HashSet<>();

    public boolean isPath(char begin, char end) {
        visited.clear();
        return dfs(graph, begin, end);
    }

    private boolean dfs(Map<Character, List<Character>> graph, char begin, char end) {
        if (visited.contains(begin) || !graph.containsKey(begin)) {
            return false;
        }

        boolean reached = false;
        for (char next : graph.getOrDefault(begin, List.of())) {
            visited.add(next);
            if (next == end) {
                return true;
            }
            dfs(graph, next, end);
        }

        return false;
    }

    public static void main(String[] arg) {
        Graph test = new Graph();
        System.out.println("isPath(A, B) - " + test.isPath('A', 'B'));
        System.out.println("isPath(A, D)" + test.isPath('A', 'D'));
    }
}
