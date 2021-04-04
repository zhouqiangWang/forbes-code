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
        List<Integer> list = Arrays.asList(0, 1, 3, 5);
        pw.println(list.subList(1, 3));

        _DataStructureTest ins = new _DataStructureTest();
        Map<String, Integer> map = new HashMap<>();
        pw.println(new HashSet<>(map.values()).size());
        List<Integer> singleList = Collections.singletonList(2);
//        singleList.add(3); immutable
        pw.println(singleList);
        String[] strs = new String[]{"2", "9", "3"};
        List<Integer> list2 =
                Arrays.stream(strs).map(Integer::valueOf).sorted().collect(Collectors.toList());

        pw.println(list2);
        pw.println(String.join("", strs));
        pw.println(Collections.binarySearch(list, 2));
        pw.println(Character.isDigit('1'));
        int int_val = 10_000;
        pw.println(int_val);
        Random random = new Random();
        random.nextInt(10);

        var a = 1;
        var b = Integer.valueOf(10);
        var c = true;
        var d = "sa";
        pw.println(b.getClass());
        pw.println(d.getClass());

        int[] arr2 = list.stream().mapToInt(i -> i).toArray();
        pw.println(Arrays.toString(arr2));
        Integer[] arr3 = new Integer[]{1, 2 ,3};
        Arrays.sort(arr3, (a1, a2) -> a2 - a1);

        Iterable<String> lines = () -> "this\nthat\nthe_other".lines().iterator();
        lines.forEach(pw::println);
        pw.println(String.join("\n", lines));
        List<List<Integer>> forwardList = new ArrayList<>();
        forwardList.sort(Comparator.comparingInt(a1 -> a1.get(1)));
        Arrays.asList();
        Map<Integer, Set<Integer>> map2 = new HashMap<>();
        map2.computeIfAbsent(1, k -> new HashSet<>()).add(2);
        for (Map.Entry<Integer, Set<Integer>> entry : map2.entrySet()) {
            entry.getValue();
        }
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        Set<Integer> set = new HashSet<>();
        pw.println(Arrays.asList(arr));


        pw.flush();
        pw.close();
    }
}
