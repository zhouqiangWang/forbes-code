import java.util.*;

public class A_ArticulationPoints {
    public List<Integer> getCriticalNodes(int[][] edges, int numNodes) {
        List<Integer>[] adjMap = new ArrayList[numNodes];

        for (int i = 0; i < numNodes; i++) {
            adjMap[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adjMap[edge[0]].add(edge[1]);
            adjMap[edge[1]].add(edge[0]);
        }
        int[] ids = new int[numNodes];
        int[] low = new int[numNodes];

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < numNodes; i++) {
            if (ids[i] == 0) {
                dfs(i, -1, ids, low, adjMap, set);
            }
        }

        List<Integer> res = new ArrayList<>(set);
        // test

        return res;
    }
    int id = 1; // id start from 1.

    void dfs (int cur, int pre, int[] ids, int[] low, List<Integer>[] adjMap, Set<Integer> res) {
        int outDegree = 0;
        ids[cur] = low[cur] = id++;

        for (int next : adjMap[cur]) {
            if (next == pre) continue;

            if (ids[next] == 0) {
                outDegree++;
                dfs(next, cur, ids, low, adjMap, res);
                low[cur] = Math.min(low[cur], low[next]);
                if ((ids[cur] <= low[next] && pre != -1) || (pre == -1 && outDegree > 1)) {
                    res.add(cur);
                }
            } else {
                low[cur] = Math.min(low[cur], ids[next]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 5}, {5, 6}, {3, 4}};
        A_ArticulationPoints ins = new A_ArticulationPoints();

        System.out.println(ins.getCriticalNodes(edges, 7));

        int[][] edges2 = {{0, 1}, {0, 2}, {1, 2},{2, 3},{3, 4},  {2, 5}, {5, 6}, {6, 7}, {7, 8}, {8, 5}};
        System.out.println(ins.getCriticalNodes(edges2, 9));
    }

}


