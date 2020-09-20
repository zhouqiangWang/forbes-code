import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class LeetWeek_0919 {
    public String reorderSpaces(String text) {
        char[] chs = text.toCharArray();
        int len = chs.length;
        int spaces = 0;
        int w = 0;
        int i = 0;
        List<String> words = new ArrayList<>();
        while (i < len) {
            if (chs[i] == ' ') {
                spaces++;
                i++;
            } else {
                w++;
                StringBuilder word = new StringBuilder();
                while (i < len && chs[i] != ' ') {
                    word.append(chs[i++]);
                }

                words.add(word.toString());
            }
        }

        int gap = spaces / (w - 1);
        int tailing = spaces % (w - 1);
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            sb.append(word);
            appendSpace(sb, gap);
        }

        appendSpace(sb, tailing);

        return sb.toString();
    }

    void appendSpace(StringBuilder sb, int n) {
        while (n-- > 0) {
            sb.append(' ');
        }
    }

    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);

        LeetWeek_0919 test = new LeetWeek_0919();

        pw.println(test.reorderSpaces("  this   is  a sentence "));

        pw.println((-10 % 3));

        pw.flush();
        pw.close();
    }
}
