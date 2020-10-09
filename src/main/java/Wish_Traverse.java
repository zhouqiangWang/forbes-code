import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
Let's say you have a Premier Platinum membership of United Airlines with
a lot of bonus miles in your account to spend, and you're planning a series
of flight trip for a vacation! SFO->JFK is going to cost you 20k reward
miles non-stop, but SFO->DFW (6k) + DFW->ATL (4k) + ATL->JFK (4k), you
could use stopovers to save more reward miles for future trips and
explore more cities with fun!

Let's write a program to find out the cheapest flights with at most K stops.
Given all the cities and flights with price tag, together with starting
city src and the destination dst, your task is to find the cheapest price
from src to dst with up to k stops.

Example: `find_cheapest_price(edges=[[0,1,100],[1,2,100],[0,2,500]], src=0, dst=2, k=1)` returns 200
0 -> 1 -> 2

`find_cheapest_price(edges=[[0,1,100],[1,2,100],[0,2,500]],src=0,dst=2,k=0)` returns 500

A ->B:
path1 2 stop: 300
path2 5 stops, 200

[[0,1,100],[1,2,100],[0,2,500]]
1. Map<Integer, List<int[]>>
   0, [1, 100]
   s.  dst, cost
2.

DFS:

int minCost;
Set<Integer> visited;

void dfs(Map<Integer, List<int[]>> map, int src, int dst, int k, int cost, int stop) {
    if (src == dst) {
        minCost = min(minCost, cost);
        return;
    }
    if (stop > k) return;
    if (visited.contains(src)) {
        return;
    }
    if (!map.containsKey(src)) {
        return;
    }
    visited.add(src);
    for (int[] i : map.get(src)) {
        dfs(map, i[0], dst, k, cost + i[1], stop + 1);
    }
}

time: O(n)
space: O(n)
*/
public class Wish_Traverse {

    int minCost = Integer.MAX_VALUE;
    Set<Integer> visited = new HashSet<>();
    int find_cheapest_price(int[][] edges, int src, int dst, int k) {
        minCost = Integer.MAX_VALUE;
        visited = new HashSet<>();
        // 1. construct graph.
        Map<Integer, List<List<Integer>>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(Arrays.asList(edge[1], edge[2]));
        }
        System.out.println(graph);
        // 2. dfs
        dfs(graph, src, dst, k, 0, 0);

        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }

    void dfs(Map<Integer, List<List<Integer>>> map, int src, int dst, int k, int cost, int stop) {
        if (src == dst) {
            minCost = Math.min(minCost, cost);
            return;
        }
        if (stop > k) return;
        if (!map.containsKey(src)) {
            return;
        }
        for (List<Integer> i : map.get(src)) {
            if (visited.contains(i.get(0))) {
                continue;
            }
            visited.add(i.get(0));
            dfs(map, i.get(0), dst, k, cost + i.get(1), stop + 1);
            visited.remove(i.get(0));
        }
    }

    public int minimumOneBitOperations(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0, 0);
        memo.put(1, 1);
        return helper(n, memo);
    }

    int helper(int n, Map<Integer, Integer> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int i = 1;
        while ((n >>> i) > 0) {
            i++;
        }

        int high = 1 << (i - 1);
        int res = 2 * high + helper(n ^ high, memo);
        memo.put(n, res);
        return res;
    }

    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);
        int[] num = new int[] {0, 2, 2, 4, 5};
        pw.println(Arrays.binarySearch(num, 1));
        pw.println(Arrays.binarySearch(num, 3));

        Wish_Traverse sol = new Wish_Traverse();

        // int[][] edges = new int[][]{{0,2,500},{0,1,100},{1,2,100}};
        int[][] edges = new int[][]{{1,2,10},{2,0,7},{1,3,8},{4,0,10},{3,4,2},{4,2,10},{0,3,3},{3,1,6},{2,4,5}};
        /**
         1 -> 2 : 100
         2 -> 0 : 7
         1 -> 3 : 8
         4 - 0 : 10
         3 - 4 : 2
         4 - 2 : 10
         0 - 3 : 3
         3 - 1 : 6
         2 - 4 : 5

         cost: 3 + 2
         0 - 3 - 4
         */
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 0);
        map.put(2, 2);
        map.put(4, 4);
        map.put(6, 6);

        pw.println(map.floorKey(2));
        pw.println(sol.find_cheapest_price(edges, 0, 4, 1));

        pw.println(sol.minimumOneBitOperations(3));

        pw.flush();
        pw.close();
    }
}
