import java.util.*;

public class Robin_AdjList {
    List<Integer> recovery(int[][] pairs) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for (int[] pair : pairs) {
            adj.computeIfAbsent(pair[0], key -> new ArrayList<>()).add(pair[1]);
            adj.computeIfAbsent(pair[1], key -> new ArrayList<>()).add(pair[0]);
            if (set.contains(pair[0])) {
                set.remove(pair[0]);
            } else {
                set.add(pair[0]);
            }

            if (set.contains(pair[1])) {
                set.remove(pair[1]);
            } else {
                set.add(pair[1]);
            }
        }

        int start = set.iterator().next();
        Set<Integer> visited = new HashSet<>();
        visited.add(start);

        List<Integer> res = new ArrayList<>();
        int n = pairs.length + 1;

        while (res.size() < n) {
            res.add(start);
            visited.add(start);
            for (int next : adj.get(start)) {
                if (!visited.contains(next)) {
                    start = next;
                    break;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Robin_AdjList test = new Robin_AdjList();

        System.out.println(test.recovery(new int[][]{{3, 5}, {5, 1}, {1, 2}, {2, 4}}));
    }
}
