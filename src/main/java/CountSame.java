import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountSame {
    public int numTriplets(int[] nums1, int[] nums2) {
        Map<Long, Integer> product1 = new HashMap<>();
        Map<Long, Integer> sq1 = new HashMap<>();
        Map<Long, Integer> product2 = new HashMap<>();
        Map<Long, Integer> sq2 = new HashMap<>();

        for (int i : nums1) {
            long ii = (long)i * (long)i;
            sq1.put(ii, sq1.getOrDefault(ii, 0) + 1);
        }

        for (int i = 0; i < nums1.length - 1; i++) {
            for (int j = i + 1; j < nums1.length; j++) {
                long p = (long)nums1[i] * (long)nums1[j];
                if (canSqrt(p)) {
                    product1.put(p, product1.getOrDefault(p, 0) + 1);
                }
            }
        }

        for (int i : nums2) {
            long ii = (long)i * (long)i;
            sq2.put(ii, sq2.getOrDefault(ii, 0) + 1);
        }

        for (int i = 0; i < nums2.length - 1; i++) {
            for (int j = i + 1; j < nums2.length; j++) {
                long p = (long)nums2[i] * (long)nums2[j];
                if (canSqrt(p)) {
                    product2.put(p, product2.getOrDefault(p, 0) + 1);
                }
            }
        }

        return countSame(product1, sq2) + countSame(product2, sq1);
    }
    boolean canSqrt(long n) {
        return (long)(Math.sqrt(n)) * (long)(Math.sqrt(n)) == n;
    }

    int countSame(Map<Long, Integer> product1, Map<Long, Integer> sq2) {
        if (product1.size() > sq2.size()) {
            return countSame(sq2, product1);
        }
        int res = 0;
        for (long k1 : product1.keySet()) {
            if (sq2.containsKey(k1)) {
                res += product1.get(k1) * sq2.get(k1);
            }
        }

        return res;
    }

    public int minCost(String s, int[] cost) {
        char[] chs = s.toCharArray();
        int res = 0;
        for (int i = 0; i < cost.length; i++) {
            int j = i + 1;
            int sum = cost[i];
            int max = cost[i];
            while (j < chs.length && chs[j] == chs[i]) {
                sum += cost[j];
                max = Math.max(cost[j], max);
                j++;
            }
            res += sum - max;
            i = j - 1;
        }

        return res;
    }

    class UF{
        int[] p;
        int[] size;
        int max = 1;
        public UF(int n) {
            p = new int[n+1];
            size = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                p[i] = i;
                size[i] = 1;
            }
        }

        int find(int i) {
            while (p[i] != i) {
                i = p[i];
                p[i] = p[p[i]];
            }

            return i;
        }
        void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa != pb) {
                p[pa] = pb;
                size[pb] += size[pa];
                max = Math.max(max, size[pb]);
            }
        }
    }
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UF u1 = new UF(n);
        UF u2 = new UF(n);

        Arrays.sort(edges, (e1, e2) -> e2[0] - e1[0]);

        int res = 0;
        for (int[] edge : edges) {
            if (edge[0] == 1 || edge[0] == 3) {
                int p1 = u1.find(edge[1]);
                int p2 = u1.find(edge[2]);
                if (p1 == p2) {
                    res++;
                } else {
                    u1.union(edge[1], edge[2]);
                }
            }
            if (edge[0] >= 2) {
                int p1 = u2.find(edge[1]);
                int p2 = u2.find(edge[2]);
                if (p1 == p2) {
                    res++;
                } else {
                    u2.union(edge[1], edge[2]);
                }
            }
        }

        if (u1.max == n && u2.max == n) {
            return res;
        }

        return -1;
    }

    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);

        CountSame t = new CountSame();
        int[] nums1 = new int[]{43024,99908};
        int[] nums2 = new int[]{1864};

        pw.println(t.numTriplets(nums1, nums2));

        String s = "abaac"; int[] cost = new int[]{1,2,3,4,5};
        pw.println(t.minCost(s, cost));

        int[][] edges = new int[][]{{3,1,2},{3,2,3},{1,1,3},{1,2,4},{1,1,2},{2,3,4}};
        pw.println(t.maxNumEdgesToRemove(4, edges));

        pw.flush();
        pw.close();
    }
}
