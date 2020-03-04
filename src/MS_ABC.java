import java.util.PriorityQueue;

public class MS_ABC {
    public static String solution(int A, int B, int C) {
        // write your code in Java SE 8
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        if (A > 0)  maxHeap.add(new int[]{A, 0});
        if (B > 0)  maxHeap.add(new int[]{B, 1});
        if (C > 0)  maxHeap.add(new int[]{C, 2});
        StringBuilder res = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            int[] next = maxHeap.poll();
            char c = (char)(next[1] + 'a');
            if (res.length() < 2 || res.charAt(res.length() - 1) != c || res.charAt(res.length() - 2) != c) {
                res.append(c);
                next[0]--;
                if (next[0] > 0)
                    maxHeap.add(next);
            } else if (!maxHeap.isEmpty()){
                int[] next2 = maxHeap.poll();
                char c2 = (char)(next2[1] + 'a');
                res.append(c2);
                next2[0]--;
                maxHeap.add(next);
                if (next2[0] > 0)
                    maxHeap.add(next2);
            } else {
                return res.toString();
            }
        }
        return res.toString();
    }

    public static void main(String[] ag) {
        System.out.println(solution(6,1, 1));
    }
}
