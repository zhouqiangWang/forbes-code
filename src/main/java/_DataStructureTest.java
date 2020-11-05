import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class _DataStructureTest {
    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);
        pw.println("123".indexOf('.'));

        Map<String, Queue<String>> rels = new HashMap<>();
        rels.computeIfAbsent("key", k -> new LinkedList<>()).add("c");

        Deque<Integer> deque = new ArrayDeque<>();
//        deque.pollFirst();
//        throw new UnsupportedOperationException("");
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }

        };
        int[] arr  = {1, 2};
        Arrays.stream(arr).boxed().sorted(comparator).collect(Collectors.toList());

        pw.println(-112 % 10);
        List<Integer> list = Arrays.asList(0, 1, 2, 3);
        pw.println(list.subList(1, 3));

        _DataStructureTest ins = new _DataStructureTest();
        Map<String, Integer> map = new HashMap<>();
        pw.println(new HashSet<>(map.values()).size());
        List<Integer> singleList = Collections.singletonList(2);
//        singleList.add(3); immutable
        pw.println(singleList);

        pw.flush();
        pw.close();
    }
}
