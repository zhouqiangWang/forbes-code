import java.util.*;

public class Roblox_CourseDependency {
    public static void main(String[] args) {
        String[][] courses = {{"A", "B"}, {"A", "C"}, {"B", "C"}, {"C", "D"}, {"F", "G"}};

        System.out.println(getPath(courses));

        System.out.println(dfs(courses));

        System.out.println(isPerfectSquare(808201));
    }

    // BFS
    static List<String> getPath(String[][] courses) {
        Map<String, Integer> degree = new HashMap<>();
        Map<String, List<String>> depends = new HashMap<>();
        for (String[] pair : courses) {
            degree.put(pair[1], degree.getOrDefault(pair[1], 0) + 1);
            degree.put(pair[0], degree.getOrDefault(pair[0], 0));
            depends.putIfAbsent(pair[0], new ArrayList<>());
            depends.get(pair[0]).add(pair[1]);
        }

        Queue<String> queue = new LinkedList<>();

        for (Map.Entry<String, Integer> entry : degree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }

        List<String> res = new ArrayList<>();

        while(!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                String cur = queue.poll();
                res.add(cur);
                if (depends.containsKey(cur)) {
                    for (String dep : depends.get(cur)) {
                        degree.put(dep, degree.get(dep) - 1);
                        if (degree.get(dep) == 0) {
                            queue.offer(dep);
                        }
                    }
                }
            }
        }

        return res;
    }

    static List<List<String>> res;
    static Set<String> visited;
    // DFS, traverse all paths.
    static List<List<String>> dfs(String[][] courses) {
        res = new ArrayList<>();
        visited = new HashSet<>();

        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();
        for (String[] edge : courses) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            inDegree.put(edge[1], inDegree.getOrDefault(edge[1], 0) + 1);
            inDegree.put(edge[0], inDegree.getOrDefault(edge[0], 0));
        }

        for (String start : inDegree.keySet()) {
            if (inDegree.get(start) > 0) continue;
            List<String> path = new ArrayList<>();
            helper(graph, start, path);
            Collections.reverse(path);
            res.add(path);
        }

        return res;
    }

    static void helper(Map<String, List<String>> graph, String start, List<String> path) {
        if (graph.containsKey(start)) {
            for (String next : graph.get(start)) {
                if (!visited.contains(next)) {
                    visited.add(next);
                    helper( graph, next, path);
                }
            }
        }
        path.add(start);
    }

    public static boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        int l = 1, r = num / 2 ;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}
