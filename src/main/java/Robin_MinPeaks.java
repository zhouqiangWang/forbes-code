import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Robin_MinPeaks {
    class Node {
        Node prev;
        Node next;
        int val;
        public Node (int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

    Node head = new Node(Integer.MIN_VALUE);
    Node tail = new Node(Integer.MIN_VALUE);

    void construct(int[] num) {
        head.next = tail;
        tail.prev = head;

        for (int n : num) {
            addTail(n);
        }
    }

    void addTail(int n) {
        add(n, tail.prev);
    }

    void add(int n, Node node) {
        Node newNode = new Node(n);
        newNode.prev = node;
        newNode.next = node.next;
        node.next.prev = newNode;
        node.next = newNode;
    }

    Node remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        return node;
    }

    List<Integer> deleteMinPeaks(int[] nums) {
        List<Integer> res = new ArrayList<>();

        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        construct(nums);
        Node cur = head.next;

        while (cur != tail) {
            if (cur.val > cur.prev.val && cur.val > cur.next.val) {
                minHeap.add(cur);
            }
            cur = cur.next;
        }

        while (!minHeap.isEmpty()) {
            cur = minHeap.poll();
            res.add(cur.val);
            remove(cur);
            if (cur.prev.val > cur.next.val) {
                if (cur.prev.val > cur.prev.prev.val) {
                    minHeap.add(cur.prev);
                }
            } else if (cur.prev.val < cur.next.val) {
                if (cur.next.val > cur.next.next.val) {
                    minHeap.add(cur.next);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);

        Robin_MinPeaks ins = new Robin_MinPeaks();
        int[] nums = {2, 7, 8, 5, 1, 6, 3, 9, 4};
        pw.println(ins.deleteMinPeaks(nums));

        pw.flush();
        pw.close();
    }
}
