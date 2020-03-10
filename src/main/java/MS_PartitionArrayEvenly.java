import java.util.*;

public class MS_PartitionArrayEvenly {
    static List<List<Integer>> part(int[] arr, int n) {
        int[] sums = new int[n];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> sums[a] - sums[b]);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            minHeap.add(i);
            res.add(new ArrayList<>());
        }

        Arrays.sort(arr);

        for (int i = arr.length - 1; i >= 0; i--) {
            int cur = minHeap.poll();
            res.get(cur).add(arr[i]);
            sums[cur] += arr[i];
            minHeap.add(cur);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(part(new int[]{1,2,3,4,5,6,7,8,9,10}, 3));
    }
}
