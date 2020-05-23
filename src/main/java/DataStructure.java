import com.sun.tools.javac.util.Pair;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static java.util.Calendar.MONTH;

public class DataStructure {
    private static final String FILE_INPUT = System.getProperty("user.dir") + "/src/main/java/input.txt";
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
        String str = "test";
        sb.reverse().toString();
        String.valueOf(12);
        pw.println(Character.forDigit(1, 10));
        pw.println((int)Math.pow(2, 3));
        int[][] dirs = {{1, 2}, {3, 4}};
        Arrays.sort(dirs, Comparator.comparingInt(d2 -> d2[0]));
        pw.println(str);
        pw.println(str.substring(0, 1));
        Queue<int[]> queue2 = new LinkedList<>();
        queue2.offer(new int[]{b, b});
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
        pw.println(1e-6);
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
        pw.println((char)('a' + 1));
        pw.println(sb.charAt(0));

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a2,b2) -> b2[0] - a2[0]);
        maxHeap.add(new int[]{6, 0});
        maxHeap.add(new int[]{1, 1});
        maxHeap.add(new int[]{1, 2});

        Boolean[][] memo = new Boolean[2][2];
        memo[0][0] = true;
        pw.println(memo[0][0]);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2018);
        calendar.set(MONTH, Calendar.OCTOBER);
//        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
        pw.println(calendar.get(MONTH));
        pw.println(calendar.get(Calendar.DAY_OF_WEEK));
        pw.println("second Tuesday - " + (calendar.get(Calendar.DAY_OF_MONTH) + 7));
        pw.println(calendar.getTime());
        Set<List<Integer>> set2 = new HashSet<>();
        pw.println(Integer.bitCount(3));
        char[] chs = new char[] {'a', 'b', 'c', 'd'};
        sb = new StringBuilder();
        sb.append(chs, 0, 2);
        pw.println(sb.toString());
        Queue<List<Long>> heap = new PriorityQueue<>((a1, b1) -> (int)(b1.get(0) - a1.get(0)));
        pw.printf("%x\n", Long.reverse(1)>>32 & 0xFFFFFFFFL);
        pw.printf("sequence = %x\n", 1000001234l | 0x100000000L & 0x1FFFFFFFFL);
        pw.println(Long.reverse(80000000L << 32));
        pw.println(map.get(a));
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) {
            pw.println(iter.next());
        }
        pw.println(System.currentTimeMillis());
        queue.add(1);
        pw.println(queue);
        pw.println(queue.remove());
        pw.println(queue);
        AtomicInteger atomicInteger = new AtomicInteger();
        pw.println(atomicInteger.get());
        atomicInteger.getAndAdd(100);
        pw.println(atomicInteger.addAndGet(23));
        pw.println(atomicInteger);
        pw.println("ABC".compareTo("BCD"));
        pw.println((char)('z' + 1));
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.iterator().hasNext();
        String[] strings = new String[]{"ab 1", "cd 2", "vd 3"};
        Arrays.sort(strings, (s1, s2) -> {
            int s1Space = s1.indexOf(" ");
            int s2Space = s2.indexOf(" ");
            int s1Char = s1.charAt(s1Space);
            int s2Char = s2.charAt(s2Space);

            if (s1Char < '9') {
                return 1;
            }
            if (s2Char < '9') {
                return -1;
            }
            int logDiff = s1.substring(s1Space + 1).compareTo(s2.substring(s2Space + 1));
            if (logDiff != 0) {
                return logDiff;
            }

            return s1.substring(0, s1Space).compareTo(s2.substring(0, s2Space));
        });
        pw.println(~7);
        pw.println("string".indexOf(".", 1));
        Pair<Integer, String> pair;
        "ss".toLowerCase();
        pw.println(String.join(" ", strings));
        pw.println("12345".substring(0,5));



        pw.flush();
        pw.close();
        sc.close();
    }

    private static int gcd(int a, int b) {
        if(b == 0){
            return a;
        }
        return gcd (b, a % b);
    }


    @Override
    public String toString() {
        return super.toString();
    }
}

