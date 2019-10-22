import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Calendar.MONTH;

public class DataStructure {
    private static final String FILE_INPUT = System.getProperty("user.dir") + "/src/input.txt";
    private static final String FILE_OUTPUT = "output.txt";

    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(new FileReader(FILE_INPUT));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//        PrintWriter pw = new PrintWriter(new FileWriter(FILE_OUTPUT));
        PrintWriter pw = new PrintWriter(System.out);

        Map<Character, Integer> map = new HashMap<>();

        SortedSet<Map.Entry<Character, Integer>> sortedSet = new TreeSet<>((o1, o2) -> o2.getValue() - o1.getValue());
        sortedSet.addAll(map.entrySet());

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        pw.println(queue);
        queue.size();
        queue.poll();

        int[] arr = new int[4];
        Arrays.sort(arr);

        List<Integer> list = new ArrayList<>();
        List<List<Integer>> listMap = new ArrayList<>(4);
        pw.println(listMap);
        pw.println(Integer.MAX_VALUE);

        Arrays.fill(arr, 1);

        "sad".length();
        Stack<Character> stack = new Stack<>();
        stack.push('c');
        stack.peek();

        Character.isDigit('0');

        Set<Integer> set = new HashSet<>();
        list.isEmpty();
        "sda".toCharArray();
        StringBuilder sb = new StringBuilder();
//        map.getOrDefault();

        String[] strs = "1,2,3,4,11,12,13,".split(",");

        pw.println(Arrays.toString(strs));
        Integer.valueOf("1");
        "st".startsWith("0");
//        int in = Integer.parseInt("o1");
//        pw.println(in);
        int[][] twoDarr = new int[2][3];
//        Arrays.sort(twoDarr, (o1, o2) -> o1[0] - o2[0]);
        pw.println(UUID.randomUUID().toString());
        Random random = new Random();
        random.nextInt(11);
        pw.println(random.nextInt());
        pw.println(Integer.MAX_VALUE);
        set.iterator();
        Integer integer = 2;
        integer.intValue();
        String.join("[.]", strs);
        pw.println(Arrays.toString(strs));
        StringBuilder builder = new StringBuilder();
        Arrays.sort(strs, (s1, s2) -> s1.charAt(0) - s2.charAt(0));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);
        minHeap.poll();
        long a = 10;
        int b = Integer.MIN_VALUE;
        map.keySet();
        list.sort(((o1, o2) -> o1 - o2));
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.floorEntry(1);
        TreeMap<Integer, Integer>[] array = new TreeMap[10];
        Collections.reverse(list);
        pw.println(302 % 20);
        map.values();
        "sa".toCharArray();
        queue.offer(1);
        queue.poll();
        map.putIfAbsent('c', 1);
        list.stream().collect(Collectors.toList());
        queue.poll();
//        stack.push()
//        set.contains()
//        list.get(0);
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>();
        Map.Entry<Character, Integer> entry;
//        entry.getValue();
        PriorityQueue<Map.Entry<Character, Integer>> priorityQueue = new PriorityQueue<>();
//        priorityQueue.addAll(map.entrySet());
        maxHeap.peek();
//        String.valueOf()
        map.keySet();
        pw.println(1<<31);
        pw.println(Math.abs((long)1<<31));
        pw.println(Arrays.toString(new int[0]));
        int[][] arr2 = {{0, 2}, {1, 3}, {2, 4}};
        int[] tmp = arr2[1];
        pw.println(arr2[1]);
        arr2[1] = arr2[2];
        pw.println(arr2[1]);
        pw.println(arr2[2]);
        arr2[2] = tmp;
        pw.println(Arrays.toString(arr2));

        Date d=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("MMMMMMM",Locale.US);
        pw.println(Calendar.getInstance().getDisplayName(MONTH, Calendar.LONG, Locale.US));
        pw.println(sdf.format(d));

        pw.flush();
        pw.close();
        sc.close();
    }
}

