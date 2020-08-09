import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyHashSet {
    /** Initialize your data structure here. */
    int size = 0;
    private static final double FACTOR = 0.75;
    int capacity = 0;
    List<Integer>[] set;
    public MyHashSet() {
        capacity = 2;
        set = new LinkedList[2];
    }

    public void add(int key) {
        if (contains(key)) return;
        if (size >= capacity * FACTOR) {
            // resize;
            capacity *= 2;
            List<Integer>[] old = set;
            set = new LinkedList[capacity];
            for (List<Integer> list : old) {
                if (list == null) continue;
                for (int val : list) {
                    insert(val);
                }
            }
        }
        size++;
        insert(key);
    }

    private void insert(int key) {
        int i = key % capacity;
        if (set[i] == null) {
            set[i] = new LinkedList<Integer>();
        }
        set[i].add(key);
    }

    public void remove(int key) {
        int i = key % capacity;
        if (set[i] != null) {
            Iterator<Integer> iter = set[i].iterator();
            while (iter.hasNext()) {
                if (iter.next() == key) {
                    iter.remove();
                    break;
                }
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int i = key % capacity;
        if (set[i] == null) return false;
        for (int val : set[i]) {
            if (val == key) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);

        MyHashSet test = new MyHashSet();

        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        pw.println(test.contains(2));
        test.remove(2);
        pw.println(test.contains(2));

        pw.flush();
        pw.close();
    }
}
