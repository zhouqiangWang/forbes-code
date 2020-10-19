import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LexSmallest {
    public String findLexSmallestString(String s, int a, int b) {
        Set<Integer> pos = new HashSet<>();

        int next = 0;
        int len = s.length();
        List<String> candi = new ArrayList<>();
        while (!pos.contains(next)) {
            pos.add(next);
            candi.add(s.substring(next) + s.substring(0, next));
            next = (next + b) % len;
        }
        System.out.println(candi);

        String min = s;
        for (String cand : candi) {
            String newCan = lexMin(cand, a);
            if (min.compareTo(newCan) > 0) {
                min = newCan;
            }
        }

        return min;
    }

    String lexMin(String s, int a) {
        int diff = dif(s.charAt(1), a);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i % 2 == 0) {
                res.append(c);
            } else {
                int n = c - '0';
                res.append(String.valueOf((n + diff) % 10));
            }
        }

        return res.toString();
    }

    int dif(char c, int a) {
        int n = c - '0';
        if (a == 5) {
            return 10 + (n % 5) - n;
        } else if (a % 2 == 1) {
            return 10 - n;
        }

        if (n % 2 == 1) {
            return 11 - n;
        } else {
            return 10 - n;
        }
    }
    public static void main(String[] arg) {
        PrintWriter pw = new PrintWriter(System.out);

        LexSmallest ins = new LexSmallest();

        pw.println(ins.findLexSmallestString("5525", 9, 2));
        pw.println(ins.findLexSmallestString("74", 5, 1));

        pw.flush();
        pw.close();
    }
}
