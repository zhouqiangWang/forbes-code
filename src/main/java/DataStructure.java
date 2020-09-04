import com.sun.tools.javac.util.Pair;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.Calendar.MONTH;

public class DataStructure {
    private static final String FILE_INPUT = System.getProperty("user.dir") + "/src/main/java/input.txt";
    private static final String FILE_OUTPUT = "output.txt";

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
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
        treeMap.put(10, 100);
        treeMap.put(0, 80);
        treeMap.put(2, 200);
        pw.println(treeMap);
        pw.println(treeMap.floorEntry(1));
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
        int i = 5;
        pw.println(" i = " + i);
        pw.println("i = " + Integer.toBinaryString(i));
        pw.println("-i = " + Integer.toBinaryString(-i));

        pw.println(" (-i & i) = " + (-i & i));
        pw.println(" (-i ^ i) = " + Integer.toBinaryString(i ^ -i));
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
        "ss".equals("s");
        pw.println(String.join(" ", strings));
        pw.println("12345".substring(0,5));
        sb = new StringBuilder("123");
        pw.println(sb.append(sb.reverse()).toString());
        strs = "x+5-3+x=6+x-2".split("(?=[-+])");
        pw.println(Arrays.toString(strs));
        pw.println(Collections.binarySearch(list, 4));
        pw.println("sda".contains("."));
        String[] ips = "172.16.254.1".split("\\.");
        pw.println(ips.length);
        pw.println(ips[0]);
        Integer.parseInt("1", 16);
        double sqrt = Math.sqrt(24);
        List<Long> listLong = new ArrayList<>();
        ArrayList<Integer> l1 = new ArrayList<>(Arrays.asList(1, 1));
        List<Integer> l3 = Arrays.asList(1, 1);
        ArrayList<Integer> l2 = new ArrayList<>(Arrays.asList(0, 32));
        HashSet<ArrayList<Integer>> set1 = new HashSet<>();
        set1.add(l1);
        pw.println(set1.contains(l2));
        pw.println(set1.add(l2));
//        pw.println(set1.add(l3));
        pw.println(set1.size());
        pw.println(l1.hashCode() == l2.hashCode());
        pw.println(l1.hashCode() + ", " + l2.hashCode());
        pw.println("123".indexOf("4"));
        Pattern pattern = Pattern.compile("Already exists: Addresses\\((.+)\\)");
        Matcher match = pattern.matcher("generic::ALREADY_EXISTS: Already exists: Addresses" +
                "({50c0c464-471c-4a43-a5cd-9b4308ce024c}).;" +
                " at");
        if (match.find()) {
            pw.println(match.group(1));
            pw.println(match.group(0));
        }
        set.add(4);
        pw.println(set.iterator().next());
        pw.println(Integer.toBinaryString(1 << 8));

        Map<String, List<String>> mapString = new HashMap<>();
        mapString.put("", Arrays.asList(""));
        map.computeIfAbsent('c', (k) -> k - 'a');

        list.clear();
        list.add(1);
        list.add(3);
        list.add(5);
        pw.println(Collections.binarySearch(list, 6));
        List list2 = new ArrayList();
        list2.add("s");
        list2.add(2);
        pw.println(list2.get(0) instanceof String);
        pw.println(list2.get(1) instanceof Integer);

        pw.println("abc".indexOf("b"));
        pw.println("abc".indexOf("d"));
        str.startsWith("");
        treeMap.clear();
        treeMap.put(1, 10);
        treeMap.put(3, 20);
        treeMap.put(5, 30);
        pw.println(treeMap.higherKey(1));
        pw.println(treeMap.ceilingKey(1));
        pw.println(treeMap.higherKey(5));
        pw.println(treeMap.ceilingKey(5));
        pw.println(treeMap.ceilingKey(6));

        pw.println(Math.log(10) / Math.log(7));

        i = 5;
        while (i < 16) {
            i += i & (-i);
            pw.println("i = " + i);
        }
        List<Object> objects = new ArrayList<>();
        objects.add(list);
        objects.add(str);
        objects.add(arr);
        objects.add(12);

        for (Object o : objects) {
            pw.println(o.getClass().getTypeName());
            if (o instanceof String) {
                pw.println("String = " + o);
            }
            if (o instanceof List) {
                pw.println("List.size = " + ((List)o).size());
            }
            if (o instanceof int[]) {
                pw.println("Array.length = " + ((int[])o).length);
            }
            if (o instanceof Integer) {
                pw.println("Integer = " + ((Integer) o).intValue());
            }
        }

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

class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private int cacheSize;

    public LRUCache(int cacheSize) {
        super(16, 0.75f, true);
        this.cacheSize = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() >= cacheSize;
    }
}
