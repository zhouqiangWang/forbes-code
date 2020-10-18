import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class _DataStructureTest {
    public String largestNumber(int[] nums) {
        Comparator<String> comparator = (o1, o2) -> {
            int i = 0, j = 0;
            while (i < o1.length() && j < o2.length()) {
                if (o1.charAt(i) > o2.charAt(j)) {
                    return -1;
                } else if (o1.charAt(i) < o2.charAt(j)) {
                    return 1;
                }
                i++; j++;
            }

            while(i < o1.length()) {
                char c1 = o1.charAt(i++);
                char c2 = o2.charAt(j - 1);
                if (c1 > c2) {
                    return -1;
                } else if (c1 < c2) {
                    return 1;
                }
            }

            while (j < o2.length()) {
                char c1 = o1.charAt(i - 1);
                char c2 = o2.charAt(j++);
                if (c1 > c2) {
                    return -1;
                } else if (c1 < c2) {
                    return 1;
                }
            }

            return 0;
        };
        List<String> list =
                Arrays.stream(nums).mapToObj(String::valueOf).sorted(comparator).collect(Collectors.toList());

        StringBuilder res = new StringBuilder();
        for (String n : list) {
            res.append(n);
        }

        StringBuilder sb = new StringBuilder();


        return res.toString();
    }
    static Map<String, Integer> memo;
    public static List<Integer> authEvents(List<List<String>> events) {
        memo = new HashMap<>();
        System.out.println(events.size());
        System.out.println(events);
        String pw = "";
        int h = 0;
        int h2 = 0;
        List<Integer> res = new ArrayList<>();
        for (List<String> event : events) {
            if (event.get(0).equals("setPassword")) {
                pw = event.get(1);
                h = hashFun(pw);
                h2 = hashFun(pw + "a") - 'a';
                System.out.println("hash = " + h + ", hash2 = " + h2);
            } else {
                int code = Integer.parseInt(event.get(1));
                if (code == h) {
                    res.add(1);
                } else if (code - h2 >= 0 && code - h2 < 128) {
                    res.add(1);
                } else {
                    res.add(0);
                }
            }
        }
        return res;

    }
    private static final int MOD = 1000000007;
    private static final double P = 131;
    private static int hashFun(String str) {
        if (memo.containsKey(str)) {
            return memo.get(str);
        }
        int l = str.length() - 1;
        double res = 0;
        for (int i = 0; i <= l; i++) {
            res = (res + (((int)str.charAt(i) * (Math.pow(P, (double)(l - i)))%MOD))%MOD)%MOD;
        }
        memo.put(str, (int)(res % MOD));
        return (int)(res % MOD);
    }

    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);
        pw.println("123".indexOf('.'));

        pw.println(authEvents(List.of(List.of("setPassword", "CXP9K63L"), List.of("authorize", "25616617"))));
        pw.println((int)(4.480604333925891e16 % 1000000007));
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
        int i = 0;
        Arrays.stream(arr).boxed().sorted(comparator).collect(Collectors.toList());
        

        pw.println(-112 % 10);

        pw.flush();
        pw.close();
    }
}
