import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class _DataStructureTest {
    public int bagOfTokensScore(int[] tokens, int P) {
        int n = tokens.length;
        HashMap<Integer, Integer>[][] memo = new HashMap[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = new HashMap<>();
            }
        }
        return dfs(tokens, P, 0, 0, memo);
    }
    int dfs(int[] tokens, int P, int i, int score, HashMap<Integer, Integer>[][] memo) {
        if (i == tokens.length - 1) {
            return P >= tokens[i] ? score + 1 : score;
        }
        if (memo[i][score].containsKey(P)) {
            return memo[i][score].get(P);
        }
        int res = dfs(tokens, P, i + 1, score, memo);
        if (score > 0) {
            res = Math.max(dfs(tokens, P + tokens[i], i + 1, score - 1, memo), res);
        }
        if (P >= tokens[i]) {
            res = Math.max(res, dfs(tokens, P - tokens[i], i + 1, score + 1, memo));
        }
        memo[i][score].put(P, res);

        return res;
    }
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        boolean[][] visit = new boolean[row][col];

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
//        visit[0][0] = true;
        queue.add(new int[]{0, 0, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == row - 1 && cur[1] == col - 1) {
                return cur[2];
            }
            if (visit[cur[0]][cur[1]]) {
                continue;
            }
            visit[cur[0]][cur[1]] = true;
            for (int[] dir : dirs) {
                int r = cur[0] + dir[0];
                int c = cur[1] + dir[1];
                if (r < 0 || r >= row || c < 0 || c >= col || visit[r][c]) {
                    continue;
                }
                int effort = Math.max(cur[2], Math.abs(heights[cur[0]][cur[1]] - heights[r][c]));
                queue.add(new int[]{r, c, effort});
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);
        pw.println("123".indexOf('.'));

        Map<String, Queue<String>> rels = new HashMap<>();
        rels.computeIfAbsent("key", k -> new LinkedList<>()).add("c");

        Deque<Integer> deque = new ArrayDeque<>();
//        deque.pollFirst();
//        throw new UnsupportedOperationException("");
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }

        };
        int[] arr  = {1, 2};
        Arrays.stream(arr).boxed().sorted(comparator).collect(Collectors.toList());

        pw.println(-112 % 10);
        List<Integer> list = Arrays.asList(0, 1, 2, 3);
        pw.println(list.subList(1, 3));

        _DataStructureTest ins = new _DataStructureTest();
        int[] tokens = {100, 200, 300, 400};
        pw.println(ins.bagOfTokensScore(tokens, 200));

        int[][] path = new int[][]{
                {1,2,2},{3,8,2},{5,3,5}
        };
        pw.println(ins.minimumEffortPath(path));

        pw.flush();
        pw.close();
    }
}
