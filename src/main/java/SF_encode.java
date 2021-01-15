import java.util.HashMap;
import java.util.Map;

public class SF_encode {

    public static String decode(String str) {
        String[] inputs = str.trim().split("\\s+");
        Map<Character, Integer> dict = new HashMap<>();
        for (int i = 0; i < inputs[1].length(); i++) {
            dict.put(inputs[1].charAt(i), i);
        }
        long dec = toDec(inputs[0], dict);
        return toBase(dec, inputs[2]);
    }

    private static long toDec(String input, Map<Character, Integer> dict) {
        long res = 0;
        int N = dict.size();
        long base = 1L;
        for (int i = input.length() - 1; i >= 0; i--) {
            int idx = dict.get(input.charAt(i));
            res += idx * base;
            base *= N;
        }
        return res;
    }

    private static String toBase(long dec, String base) {
        StringBuilder result = new StringBuilder();

        int N = base.length();
        while (dec != 0) {
            // result.append(base.charAt(new Long(dec % N)).intValue());
            result.append(base.charAt((int)(dec % N)));
            dec /= N;
        }
        return result.reverse().toString();
    }

    static void doIt(String input) {
        String[] ins = input.split(" ");
        String source = ins[1];
        String tar = ins[2];

        StringBuilder res = new StringBuilder();
        if (source.length() > tar.length()) {
            Map<Character, String> map = constructMap(source, tar);
            for (char c : ins[0].toCharArray()) {
                res.append(map.get(c));
            }
            while(res.charAt(0) == tar.charAt(0)) {
                res.deleteCharAt(0);
            }

            //return res;
        } else {

        }
    }

    static Map<Character, String> constructMap(String src, String tar) {
        int len1 = src.length();
        int len2 = tar.length();
        Map<Character, String> map = new HashMap<>();

        int l = 1;
        int n = len1;
        while (n < len2) {
            n *= len1;
            l++;
        }
        char[] tChs = tar.toCharArray();

        for (int i = 0; i < src.length(); i++) {
            StringBuilder builder = new StringBuilder();

            int m = i;
            for (int j = 0; j < l; j++) {
                builder.append(tChs[m % len1]);
                m = m / len1;
            }
            map.put(src.charAt(i), builder.toString());
        }

        return map;
    }


    public static void main(String[] args) {
        System.out.println(decode("10 0123456789 oF8"));
    }
}
