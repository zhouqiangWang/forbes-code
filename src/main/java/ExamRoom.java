import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ExamRoom {
    int capacity;
    PriorityQueue<Gap> maxHeap;
    public ExamRoom(int N) {
        capacity = N;
        maxHeap = new PriorityQueue<Gap>((a, b) -> (b.len/2 - a.len/2 != 0 ? b.len - a.len : a.l - b.l));
        Gap edgeGap = new Gap(-N, N);
        maxHeap.add(edgeGap);
    }

    public int seat() {
        Gap maxGap = maxHeap.poll();
        if (maxGap.l < 0) {
            maxGap.setLeft(0);
            maxHeap.add(maxGap);
            return 0;
        }
        if (maxGap.r >= capacity) {
            maxGap.setRight(capacity - 1);
            maxHeap.add(maxGap);
            return capacity - 1;
        }

        int mid = maxGap.l + maxGap.len / 2;
        Gap newGap = new Gap(mid, maxGap.r);

        maxHeap.add(newGap);
        maxGap.setRight(mid);
        maxHeap.add(maxGap);
        return mid;
    }

    public void leave(int p) {
        List<Gap> list = new ArrayList<Gap>(maxHeap);
        Gap left = null, right = null;
        for (Gap gap : list) {
            if (gap.l == p) {
                left = gap;
                if (p == 0) {
                    break;
                }
            }
            if (gap.r == p) {
                right = gap;
                if (p == capacity - 1) {
                    break;
                }
            }
            if (left != null && right != null) {
                break;
            }
        }
        if (p == 0) {
            maxHeap.remove(left);
            left.setLeft(0-left.r);
            maxHeap.add(left);
            return;
        }
        if (p == capacity - 1) {
            maxHeap.remove(right);
            right.setRight(capacity -1 + capacity -1 - right.l);
            maxHeap.add(right);
            return;
        }
        maxHeap.remove(left);
        maxHeap.remove(right);
        left.setLeft(right.l);
        maxHeap.add(left);
    }

    public static void main(String[] args) {
        ExamRoom solution = new ExamRoom(10);

        System.out.println(solution.seat());
        System.out.println(solution.seat());
        System.out.println(solution.seat());
        solution.leave(0);
        solution.leave(4);
        System.out.println("null");
        System.out.println(solution.seat());
        System.out.println(solution.seat());
        System.out.println(solution.seat());
        System.out.println(solution.seat());
        System.out.println(solution.seat());
        System.out.println(solution.seat());
        System.out.println(solution.seat());
        System.out.println(solution.seat());
        System.out.println(solution.seat());

    }
}

class Gap {
    int l;
    int r;
    int len;
    public Gap(int left, int right) {
        l = left;
        r = right;
        len = r -l;
    }

    public void setLeft(int left) {
        l = left;
        len = r - l;
    }

    public void setRight(int right) {
        r = right;
        len = r -l;
    }
}