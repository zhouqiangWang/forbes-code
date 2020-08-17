import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Robin_binaryPatternMatch {
    static final PrintWriter pw = new PrintWriter(System.out);

    int binaryPatternMatching(String pattern, String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'y'));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pattern.length(); i++) {
            sb.append(vowels.contains(s.charAt(i)) ? '0' : '1');
        }

        int res = pattern.equals(sb.toString()) ? 1 : 0;
        for (int i = pattern.length(); i < s.length(); i++) {
            sb.deleteCharAt(0);
            sb.append(vowels.contains(s.charAt(i)) ? '0' : '1');

            if (pattern.equals(sb.toString())) {
                res++;
            }
        }

        return res;
    }
    public static void main(String[] args) {
        Robin_binaryPatternMatch test = new Robin_binaryPatternMatch();
        pw.println(test.binaryPatternMatching("010", "amazing"));

        pw.flush();
        pw.close();
    }
}
