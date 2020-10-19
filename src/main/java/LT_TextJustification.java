import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class LT_TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();

        int i = 0;
        while (i < words.length) {
            int size = -1;
            int r = i;
            for (; r < words.length; r++) {
                int n = size + 1 + words[r].length();
                if (n <= maxWidth) {
                    size = n;
                } else {
                    break;
                }
            }
            res.add(justify(words, i, r - 1, maxWidth, size));
            i = r;
        }

        return res;
    }

    private String justify(String[] words, int l, int r, int maxWidth, int size) {
        StringBuilder sb = new StringBuilder();
        if (r == words.length - 1 || r == l) {
            // Last line or only single word in a line, use left justified.
            sb.append(words[l]);
            for (int i = l + 1; i <= r; i++) {
                sb.append(' ');
                sb.append(words[i]);
            }
            for (int i = size + 1; i <= maxWidth; i++) {
                sb.append(' ');
            }
            return sb.toString();
        }

        // center justified.
        int gap = (maxWidth - size) / (r - l);
        int oneMore = (maxWidth - size) % (r - l);
        sb.append(words[l]);
        for (int i = l + 1; i <= r; i++) {
            sb.append(' ');
            for (int j = 0; j < gap; j++) {
                sb.append(' ');
            }
            if (oneMore-- > 0) {
                sb.append(' ');
            }
            sb.append(words[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);
        LT_TextJustification ins = new LT_TextJustification();

        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        pw.println(ins.fullJustify(words, 16));

        pw.flush();
        pw.close();
    }
}
