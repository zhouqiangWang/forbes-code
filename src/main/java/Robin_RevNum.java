import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Robin_RevNum {
    static final PrintWriter pw = new PrintWriter(System.out);

    int oppositeSums(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : arr) {
            int s = n - rev(n);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int res = 0;
        for (int c : map.values()) {
            res += c * (c + 1) / 2;
        }

        return res;
    }

    int rev(int n) {
        int res = 0;
        while (n > 0) {
            res = res * 10 + n % 10;
            n /= 10;
        }

        return res;
    }

    int revNumTail0(int n) {
        int tail0 = 1;
        while (n % 10 == 0) {
            n /= 10;
            tail0 *= 10;
        }
        int res = 0;

        while (n > 0) {
            res = res * 10 + n % 10;
            n /= 10;
        }

        res = res * tail0;

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 20, 2, 11};
        Robin_RevNum ins = new Robin_RevNum();
        pw.println(ins.oppositeSums(arr));

        pw.println(ins.revNumTail0(12300));
        pw.println(ins.revNumTail0(12304));
        pw.println(ins.revNumTail0(12340));

        pw.flush();
        pw.close();
    }
}
