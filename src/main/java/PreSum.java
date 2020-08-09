import java.io.PrintWriter;
import java.util.*;

public class PreSum {
    public int maxNonOverlapping(int[] nums, int target) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        Map<Integer, List<Integer>> preSum = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            preSum.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);
        }
        sum = 0;
        if (preSum.containsKey(target)) {
            minHeap.add(new int[]{0, preSum.get(target).get(0)});
        }
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(target + sum)) {
                int idx = Collections.binarySearch(preSum.get(target + sum), i);

                if (idx > 0) {
                    idx = idx + 1;
                } else {
                    idx = - idx - 1;
                }
                if (idx < preSum.get(target + sum).size()) {
                    minHeap.add(new int[]{i + 1, preSum.get(target + sum).get(idx)});
                }
            }
        }
        // for (int i = 0; i < nums.length; i++) {
        //     int sum = 0;
        //     for (int j = i; j < nums.length; j++) {
        //         sum += nums[j];
        //         if (sum == target) {
        //             minHeap.add(new int[]{i, j});
        //             break;
        //         }
        //     }
        // }
        int res = 0;
        int prev = -1;
        while (!minHeap.isEmpty()) {
            int[] slot = minHeap.poll();
            if (slot[0] > prev) {
                prev = slot[1];
                res++;
            }
        }

        return res;
    }

    public static void main(String[] arg) {
        PreSum ins = new PreSum();
        PrintWriter pw = new PrintWriter(System.out);

        pw.println(ins.maxNonOverlapping(new int[]{0, 0, 0, 0}, 4));

        pw.flush();
        pw.close();
    }
}
