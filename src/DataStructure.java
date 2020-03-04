import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
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
        sb.append(1);
        pw.println(sb.charAt(0));

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
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(Comparator.comparingInt(a2 -> a2));
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
//        PriorityQueue<int[]> maxHeap = new PriorityQueue<>();
        Map.Entry<Character, Integer> entry;
//        entry.getValue();
        PriorityQueue<Map.Entry<Character, Integer>> priorityQueue = new PriorityQueue<>();
//        priorityQueue.addAll(map.entrySet());
//        maxHeap.peek();
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
        pw.println(1<<31);
        pw.println(3>>1);
        pw.println(Long.MIN_VALUE);
        pw.println(List.of("()"));
        List<String> zero = Arrays.asList("");
        boolean[] rowIn = new boolean[9];
        String str = "test";
        sb.reverse().toString();
        String.valueOf(12);
        pw.println(Character.forDigit(1, 10));
        pw.println((int)Math.pow(2, 3));
        int[][] dirs = {{1, 2}, {3, 4}};
        Arrays.sort(dirs, (d1, d2) -> d1[0] - d2[0]);
        pw.println(str);
        pw.println(str.substring(0, 1));
        Queue<int[]> queue2 = new LinkedList<>();
        queue2.offer(new int[]{b, b});
        double[][] twoDouble = new double[2][2];
        Arrays.fill(twoDarr[1], 2);
        pw.println(twoDarr[1][1]);
        str.charAt(0);
        map.remove(0);
        stack.peek();
        pw.println(str);
        StringBuilder builder2 = new StringBuilder(str);
        builder2.reverse().append('a').append(str);
        pw.println(builder2.toString());
        builder2.deleteCharAt(builder2.length() - 1);
        str.toCharArray();
        pw.println(1e-6);
        str.toCharArray();
        int i = 7;
        pw.println(" i = " + i);
        pw.println("i(2) = " + Integer.toBinaryString(i));
        pw.println("-i(2) = " + Integer.toBinaryString(-i));

        pw.println(" (-i & i) = " + (-i & i));
        pw.println(" (-i ^ i) = " + (i ^ -i));
        pw.println(" Integer.MAX = " + Integer.toBinaryString(Integer.MAX_VALUE));
        pw.println(" Integer.MIN = " + Integer.toBinaryString(Integer.MIN_VALUE));

        pw.println("\tasda".lastIndexOf("\t"));
        pw.println("sda".lastIndexOf("\t"));
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(10);
        deque.addLast(11);
        pw.println(deque.getFirst());
        pw.println(deque.size());
        pw.println(deque.pollFirst());
        pw.println(deque.size());
        random.nextInt(1);
        stack.peek();

        map.keySet();

        pw.println(str instanceof String);
        pw.println((int)'a');
        pw.println((int)'z');
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        pw.println(linkedList.listIterator(1).previous());
        str.toLowerCase();
        ArrayList<String[]> bucket[] = new ArrayList[0];
        pw.println((char)('a' + 1));
        pw.println(sb.charAt(0));

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a2,b2) -> b2[0] - a2[0]);
        maxHeap.add(new int[]{6, 0});
        maxHeap.add(new int[]{1, 1});
        maxHeap.add(new int[]{1, 2});


        pw.flush();
        pw.close();
        sc.close();

        Thread n = new Thread();
        n.run();

        try {

        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

