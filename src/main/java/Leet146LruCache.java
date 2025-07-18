import java.util.HashMap;
import java.util.Map;

public class Leet146LruCache {

    private int capacity;
    private int count;
    private Map<Integer, DLinkNode> map;

    public Leet146LruCache(int capacity) {
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.pre = head;

        map = new HashMap<>();
        count = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        DLinkNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        pullToHead(node);

        return node.val;
    }

    public void put(int key, int val) {
        if (map.containsKey(key)) {
            DLinkNode node = map.get(key);

            node.val = val;
            pullToHead(node);
        } else {
            DLinkNode node = new DLinkNode();
            node.key = key;
            node.val = val;
            addTop(node);
            map.put(key, node);
            count ++;
            if (count > capacity) {
                map.remove(tail.pre.key);
                popTail();
                count --;
            }
        }
    }

    class DLinkNode {
        DLinkNode pre;
        DLinkNode next;
        int key;
        int val;
    }

    DLinkNode head;
    DLinkNode tail;

    DLinkNode remove(DLinkNode node) {
        if (node == null) {
            return null;
        }

        node.pre.next = node.next;
        node.next.pre = node.pre;

        return node;
    }

    void addTop(DLinkNode node) {
        node.next = head.next;
        node.pre = head;

        if (head.next != null) {
            head.next.pre = node;
        }
        head.next = node;
    }

    void pullToHead(DLinkNode node) {
        DLinkNode n = remove(node);
        addTop(n);
    }

    void popTail() {
        remove(tail.pre);
    }

    public static void main(String[] args) {

    }
}
