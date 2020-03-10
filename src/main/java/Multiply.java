import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Multiply {
    public static Double multiply(Double a, Double b) {
        return a * b;
    }

    @Override
    public String toString() {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return super.toString();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] bytes = new byte[] {11, 12};
        System.out.println();
        System.out.println(Base64.getEncoder().encodeToString(bytes));
        System.out.println(Arrays.toString(bytes));
        bytes[0] = 1;
        bytes[1] = 112;
        System.out.println(Base64.getEncoder().encodeToString(bytes));
        System.out.println(Arrays.toString(bytes));

        System.out.println();

        char c = 'c';
        int v = c - '0';
        char d = 'c' + 2;
        System.out.println(d);

        int[] a = new int[] {1, 3, 2};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        if (a.length != 0) {

        }
        String formatStr = String.format("/as/%s/sda", "123");
        System.out.println(formatStr);
        String str = "a b c d";
        StringBuilder builder = new StringBuilder();
        builder.append((char)('a' + 1));
        int[][] grids = new int[6][7];
        System.out.println(builder.toString());
        String[] splits = str.split(" ");
        System.out.println(splits[0]);
        System.out.println(String.join(", ", splits));
        System.out.println(Multiply.multiply(1.9, 2.1));
        List<Integer> list = new ArrayList<>();
        list.sort(Comparator.comparingInt(o -> o));
        Set<Integer> hashSet = new HashSet<>();
        int[] arr = hashSet.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(arr);
        Map<String, String> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        

    }
}