import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OA_Song_0121 {

    List<Integer> scatterPalindrome(List<String> strings) {
        List<Integer> res = new ArrayList<>();
        for (String str : strings) {
            res.add(calculate(str));
        }

        return res;
    }
//
//    int cal(String str) {
//        for (int i = 0; i < str.length(); i++) {
//            Map<Character, Integer> count = new HashMap<>();
//            for (int j = i - 1; j >= 0; j--) {
//                count;
//            }
//        }
//    }

    private int calculate(String str) {
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            res += expands(str, i, i);
            res += expands(str, i, i+1);
        }
        return 0;
    }

    private int expands(String str, int l, int r) {
        int res = 0;
        while (l>=0 && r < str.length() && str.charAt(l) == str.charAt(r)) {
            res++;
            l--;
            r++;
        }
        return res;
    }

    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);

        pw.println("Hello");

        pw.flush();
        pw.close();
    }
}
